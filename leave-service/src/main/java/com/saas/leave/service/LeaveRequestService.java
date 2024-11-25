package com.saas.leave.service;

import com.saas.leave.client.EmployeeServiceClient;
import com.saas.leave.client.OrganizationServiceClient;
import com.saas.leave.dto.EmployeeDto;
import com.saas.leave.dto.TenantDto;
import com.saas.leave.dto.event.ApprovedLeaveEvent;
import com.saas.leave.dto.event.CancelledLeaveEvent;
import com.saas.leave.dto.event.RejectedLeaveEvent;
import com.saas.leave.dto.event.RequestedLeaveEvent;
import com.saas.leave.dto.request.DepartmentApproveRequest;
import com.saas.leave.dto.request.LeaveRequestRequest;
import com.saas.leave.dto.response.LeaveRequestResponse;
import com.saas.leave.enums.Day;
import com.saas.leave.enums.Status;
import com.saas.leave.exception.ResourceNotFoundException;
import com.saas.leave.mapper.LeaveEventMapper;
import com.saas.leave.mapper.LeaveRequestMapper;
import com.saas.leave.model.HolidayManagement;
import com.saas.leave.model.LeaveRequest;
import com.saas.leave.repository.HolidayManagementRepository;
import com.saas.leave.repository.LeaveRequestRepository;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;
    private final LeaveRequestMapper leaveRequestMapper;
    private final OrganizationServiceClient organizationServiceClient;
    private final EmployeeServiceClient employeeServiceClient;
    private final HolidayManagementRepository holidayManagementRepository;
    private final LeaveEventService leaveEventService;
    private final LeaveEventMapper leaveEventMapper;

    private static final Logger logger = LoggerFactory.getLogger(LeaveRequestService.class);

    public LeaveRequestResponse createLeaveRequest(UUID tenantId, LeaveRequestRequest leaveRequestRequestDTO) {
        // Validate tenant ID
        validateTenantId(tenantId);
        logger.info("Creating leave request for employee ID: {}", leaveRequestRequestDTO.getEmployeeId());

        // Retrieve tenant information
        TenantDto tenant = organizationServiceClient.getTenantById(tenantId);
        if (tenant == null) {
            throw new ResourceNotFoundException("Tenant not found with ID: " + tenantId);
        }

        // Retrieve employee information
        EmployeeDto employee = employeeServiceClient.getEmployeeById(tenantId, leaveRequestRequestDTO.getEmployeeId());
        if (employee == null) {
            throw new ResourceNotFoundException(
                    "Employee not found with ID: " + leaveRequestRequestDTO.getEmployeeId());
        }

        // Map DTO to entity
        LeaveRequest leaveRequest = leaveRequestMapper.toEntity(leaveRequestRequestDTO);
        if (leaveRequest == null) {
            throw new IllegalArgumentException("Leave request could not be created from DTO");
        }

        // Set additional fields
        leaveRequest.setTenantId(tenantId);
        leaveRequest.setEmployeeId(leaveRequestRequestDTO.getEmployeeId());

        // Calculate return date
        LocalDate returnDate = calculateReturnDate(leaveRequestRequestDTO);
        leaveRequest.setReturnDate(returnDate);

        // Check for existing department decisions
        List<LeaveRequest> requests =
                leaveRequestRepository.findByEmployeeIdAndTenantId(leaveRequest.getEmployeeId(), tenantId);
        boolean hasPendingOrApproved = requests.stream()
                .anyMatch(r ->
                        r.getDepartmentDecision() == Status.APPROVED || r.getDepartmentDecision() == Status.PENDING);

        if (hasPendingOrApproved) {
            // Check for overlapping leave requests
            List<LeaveRequest> overlappingLeaves = leaveRequestRepository.findOverlappingLeave(
                    leaveRequest.getEmployeeId(), leaveRequest.getLeaveStart(), returnDate);
            if (!overlappingLeaves.isEmpty()) {
                throw new IllegalArgumentException("Leave request overlaps with an existing leave period.");
            }
        }

        // Save leave request
        LeaveRequest savedLeaveRequest = leaveRequestRepository.save(leaveRequest);
        logger.info("Leave request created with ID: {}", savedLeaveRequest.getId());

        RequestedLeaveEvent event = leaveEventMapper.mapToRequestedLeave(savedLeaveRequest);
        leaveEventService.createRequestedEvent(event);

        // Return response DTO
        return leaveRequestMapper.toResponseDTO(savedLeaveRequest);
    }

    // Validate tenant ID
    private void validateTenantId(UUID tenantId) {
        if (tenantId == null) {
            throw new IllegalArgumentException("Tenant ID cannot be null");
        }
    }

    // Calculate return date method
    public LocalDate calculateReturnDate(LeaveRequestRequest leaveRequest) {
        LocalDate returnDate = leaveRequest.getLeaveStart();
        double remainingDays = leaveRequest.getNumberOfDays();

        // Fetch holidays from the database for the provided budget year
        Set<LocalDate> holidays = getHolidaysForBudgetYear(leaveRequest.getBudgetYearId());

        while (remainingDays > 0) {
            returnDate = returnDate.plusDays(1);
            if (isWorkingDay(returnDate, holidays)) {
                if (leaveRequest.getDay() == Day.FullDay) {
                    remainingDays--;
                } else if (leaveRequest.getDay() == Day.HalfDay) {
                    remainingDays -= 0.5;
                }
            }
        }

        logger.debug("Calculated return date: {}", returnDate);
        return returnDate;
    }

    // Fetch holidays from the database based on budget year
    private Set<LocalDate> getHolidaysForBudgetYear(UUID budgetYearId) {
        if (budgetYearId == null) {
            throw new IllegalArgumentException("Budget Year ID cannot be null");
        }

        List<HolidayManagement> holidayManagementList = holidayManagementRepository.findByBudgetYear_Id(budgetYearId);
        Set<LocalDate> holidays = new HashSet<>();
        for (HolidayManagement holidayManagement : holidayManagementList) {
            holidays.add(holidayManagement.getDate());
        }

        logger.info("Fetched holidays for budget year ID: {}", budgetYearId);
        return holidays;
    }

    // Helper method to check if a date is a working day
    private boolean isWorkingDay(LocalDate date, Set<LocalDate> holidays) {
        boolean isWorkingDay = !(date.getDayOfWeek() == DayOfWeek.SATURDAY
                || date.getDayOfWeek() == DayOfWeek.SUNDAY
                || holidays.contains(date));

        logger.debug("Is {} a working day? {}", date, isWorkingDay);
        return isWorkingDay;
    }

    public LeaveRequestResponse approveLeaveRequest(
            UUID tenantId, UUID requestId, DepartmentApproveRequest request, String decision) {
        validateTenantAndRequestId(tenantId, requestId);

        TenantDto tenant = organizationServiceClient.getTenantById(tenantId);
        if (tenant == null) {
            throw new ResourceNotFoundException("Tenant not found with ID: " + tenantId);
        }

        LeaveRequest leaveRequest = leaveRequestRepository
                .findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Leave request not found with ID: " + requestId));

        if (decision == null && request == null) {
            throw new IllegalArgumentException("Both decision and request cannot be null");
        }

        if (decision != null && request == null) {
            try {
                leaveRequest.setHrDecision(Status.valueOf(decision.toUpperCase()));
                logger.info("Leave request ID: {} approved with decision: {}", requestId, decision);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid decision value: " + decision);
            }
        }

        if (request != null && decision == null) {
            leaveRequest = leaveRequestMapper.departmentApprove(leaveRequest, request);
            logger.debug("Department approved leave request ID: {}", requestId);
        }

        LeaveRequest savedLeaveRequest = leaveRequestRepository.save(leaveRequest);
        if (savedLeaveRequest.getDepartmentDecision().equals(Status.APPROVED)
                || savedLeaveRequest.getHrDecision().equals(Status.APPROVED)) {
            ApprovedLeaveEvent event = leaveEventMapper.mapToApprovedLeave(savedLeaveRequest);
            leaveEventService.createApprovedEvent(event);
        } else if (savedLeaveRequest.getDepartmentDecision().equals(Status.REJECTED)
                || savedLeaveRequest.getHrDecision().equals(Status.REJECTED)) {
            RejectedLeaveEvent event = leaveEventMapper.mapToRejectedLeave(savedLeaveRequest);
            leaveEventService.createRejectedEvent(event);
        }
        logger.info("Leave request ID: {} updated successfully", requestId);
        return leaveRequestMapper.toResponseDTO(savedLeaveRequest);
    }

    private void validateTenantAndRequestId(UUID tenantId, UUID requestId) {
        if (tenantId == null) {
            throw new IllegalArgumentException("Tenant ID cannot be null");
        }
        if (requestId == null) {
            throw new IllegalArgumentException("Request ID cannot be null");
        }
    }

    public List<LeaveRequestResponse> getLeaveRequestsByStatus(UUID tenantId, String status) {
        validateTenantId(tenantId);

        TenantDto tenant = organizationServiceClient.getTenantById(tenantId);
        if (tenant == null) {
            throw new ResourceNotFoundException("Tenant not found with ID: " + tenantId);
        }

        Status statusEnum;
        try {
            statusEnum = Status.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid status value: " + status);
        }

        List<LeaveRequest> requests = leaveRequestRepository.findByTenantIdAndDepartmentDecision(tenantId, statusEnum);
        logger.info("Fetched {} leave requests with status: {}", requests.size(), status);
        return requests.stream().map(leaveRequestMapper::toResponseDTO).toList();
    }

    public List<LeaveRequestResponse> getAllLeaveRequests(UUID tenantId) {
        validateTenantId(tenantId);

        // Retrieve tenant information
        TenantDto tenant = organizationServiceClient.getTenantById(tenantId);

        // Retrieve all leave schedule entities
        List<LeaveRequest> leaveSchedules = leaveRequestRepository.findAll();

        // Map the entities to response DTOs
        return leaveSchedules.stream().map(leaveRequestMapper::toResponseDTO).collect(Collectors.toList());
    }

    public LeaveRequestResponse getLeaveRequestById(UUID tenantId, UUID id) {
        validateTenantId(tenantId);

        // Retrieve tenant information
        TenantDto tenant = organizationServiceClient.getTenantById(tenantId);

        // Find the leave schedule entity by ID
        LeaveRequest leaveRequest = leaveRequestRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Leave request not found with ID: " + id));

        // Map the entity to a response DTO
        return leaveRequestMapper.toResponseDTO(leaveRequest);
    }

    public LeaveRequestResponse updateLeaveRequest(UUID tenantId, UUID id, LeaveRequestRequest request) {
        validateTenantId(tenantId);

        // Retrieve tenant information
        TenantDto tenant = organizationServiceClient.getTenantById(tenantId);

        // Find the leave schedule entity by ID
        LeaveRequest leaveSchedule = leaveRequestRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LeaveRequest not found with ID: " + id));

        // Update the leave schedule entity with data from the request
        leaveRequestMapper.updateLeaveRequest(leaveSchedule, request);

        // Save the updated leave schedule entity
        LeaveRequest updatedLeaveRequest = leaveRequestRepository.save(leaveSchedule);

        // Map the updated entity back to a response DTO
        return leaveRequestMapper.toResponseDTO(updatedLeaveRequest);
    }

    public void deleteLeaveRequest(UUID tenantId, UUID id) {
        validateTenantId(tenantId);

        // Retrieve tenant information
        TenantDto tenant = organizationServiceClient.getTenantById(tenantId);

        // Find the leave request entity by ID
        LeaveRequest leaveRequest = leaveRequestRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Leave request not found with ID: " + id));

        // Map to CancelledLeaveEvent before deletion
        CancelledLeaveEvent event = leaveEventMapper.mapToCancelledLeave(leaveRequest);

        // Delete the leave request entity
        leaveRequestRepository.delete(leaveRequest);

        leaveEventService.createCancelledEvent(event);
    }
}