package com.saas.leave.mapper;

import com.saas.leave.dto.request.DepartmentApproveRequest;
import com.saas.leave.dto.request.LeaveRequestRequest;
import com.saas.leave.dto.response.LeaveRequestResponse;
import com.saas.leave.enums.Status;
import com.saas.leave.model.BudgetYear;
import com.saas.leave.model.LeaveRequest;
import com.saas.leave.model.LeaveType;
import com.saas.leave.repository.LeaveTypeRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class LeaveRequestMapper {

    private final LeaveTypeRepository leaveTypeRepository;

    public LeaveRequest toEntity(LeaveRequestRequest requestDTO) {
        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setEmployeeId(requestDTO.getEmployeeId());
        leaveRequest.setNumberOfDays(requestDTO.getNumberOfDays());
        leaveRequest.setLeaveStart(requestDTO.getLeaveStart());
        leaveRequest.setDay(requestDTO.getDay());
        leaveRequest.setDescription(requestDTO.getDescription());
        leaveRequest.setCreatedAt(LocalDateTime.now());
        leaveRequest.setHrDecision(Status.PENDING);
        leaveRequest.setDepartmentDecision(Status.PENDING);

        // Setting BudgetYear with ID
        if (requestDTO.getBudgetYearId() != null) {
            BudgetYear budgetYear = new BudgetYear();
            budgetYear.setId(requestDTO.getBudgetYearId());
            leaveRequest.setBudgetYear(budgetYear);
        }

        // Fetching LeaveType and setting it
        LeaveType leaveType = leaveTypeRepository
                .findById(requestDTO.getLeaveTypeId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid leaveTypeId: " + requestDTO.getLeaveTypeId()));
        leaveRequest.setLeaveType(leaveType);

        return leaveRequest;
    }

    public LeaveRequestResponse toResponseDTO(LeaveRequest entity) {
        LeaveRequestResponse responseDTO = new LeaveRequestResponse();
        responseDTO.setId(entity.getId());
        responseDTO.setEmployeeId(entity.getEmployeeId());
        responseDTO.setNumberOfDays(entity.getNumberOfDays());
        responseDTO.setLeaveStart(entity.getLeaveStart());
        responseDTO.setDay(entity.getDay());
        responseDTO.setReturnDate(entity.getReturnDate());
        responseDTO.setDescription(entity.getDescription());
        responseDTO.setNumberOfApprovedDays(entity.getNumberOfApprovedDays());
        responseDTO.setComment(entity.getComment());

        // Handle potential nulls for decisions
        responseDTO.setDepartmentDecision(
                entity.getDepartmentDecision() != null
                        ? entity.getDepartmentDecision().name()
                        : "UNKNOWN");
        responseDTO.setHrDecision(
                entity.getHrDecision() != null ? entity.getHrDecision().name() : "UNKNOWN");

        // Ensure LeaveType and BudgetYear are not null before accessing their IDs
        if (entity.getLeaveType() != null) {
            responseDTO.setLeaveTypeId(entity.getLeaveType().getId());
        } else {
            responseDTO.setLeaveTypeId(null);
        }

        if (entity.getBudgetYear() != null) {
            responseDTO.setBudgetYearId(entity.getBudgetYear().getId());
        } else {
            responseDTO.setBudgetYearId(null);
        }

        responseDTO.setTenantId(entity.getTenantId());
        return responseDTO;
    }

    public void updateLeaveRequest(LeaveRequest leaveRequest, LeaveRequestRequest requestDTO) {
        if (requestDTO.getEmployeeId() != null) {
            leaveRequest.setEmployeeId(requestDTO.getEmployeeId());
            log.debug("Updated employeeId to {}", requestDTO.getEmployeeId());
        }

        leaveRequest.setNumberOfDays(requestDTO.getNumberOfDays());
        log.debug("Updated numberOfDays to {}", requestDTO.getNumberOfDays());

        if (requestDTO.getLeaveStart() != null) {
            leaveRequest.setLeaveStart(requestDTO.getLeaveStart());
            log.debug("Updated leaveStart to {}", requestDTO.getLeaveStart());
        }
        if (requestDTO.getDay() != null) {
            leaveRequest.setDay(requestDTO.getDay());
            log.debug("Updated day to {}", requestDTO.getDay());
        }
        if (requestDTO.getDescription() != null) {
            leaveRequest.setDescription(requestDTO.getDescription());
            log.debug("Updated description to {}", requestDTO.getDescription());
        }
        if (requestDTO.getLeaveTypeId() != null) {
            LeaveType leaveType = leaveTypeRepository
                    .findById(requestDTO.getLeaveTypeId())
                    .orElseThrow(() -> {
                        log.error("Invalid leaveTypeId: {}", requestDTO.getLeaveTypeId());
                        return new IllegalArgumentException("Invalid leaveTypeId: " + requestDTO.getLeaveTypeId());
                    });
            leaveRequest.setLeaveType(leaveType);
            log.debug("Updated leaveTypeId to {}", requestDTO.getLeaveTypeId());
        }
    }

    public LeaveRequest departmentApprove(LeaveRequest leaveRequest, DepartmentApproveRequest request) {
        if (request.getNumberOfApprovedDays() != null) {
            leaveRequest.setNumberOfApprovedDays(request.getNumberOfApprovedDays());
            log.debug("Updated numberOfApprovedDays to {}", request.getNumberOfApprovedDays());
        }

        if (request.getDecision() != null) {
            leaveRequest.setDepartmentDecision(request.getDecision());
            log.debug("Updated departmentDecision to {}", request.getDecision());
        }
        if (request.getComment() != null) {
            leaveRequest.setComment(request.getComment());
        }

        return leaveRequest;
    }
}
