package com.saas.leave.mapper;

import com.saas.leave.dto.event.ApprovedLeaveEvent;
import com.saas.leave.dto.event.CancelledLeaveEvent;
import com.saas.leave.dto.event.RejectedLeaveEvent;
import com.saas.leave.dto.event.RequestedLeaveEvent;
import com.saas.leave.model.LeaveRequest;
import org.springframework.stereotype.Component;

@Component
public class LeaveEventMapper {

    public RequestedLeaveEvent mapToRequestedLeave(LeaveRequest leaveRequest) {

        RequestedLeaveEvent requestedLeaveEvent = new RequestedLeaveEvent();
        requestedLeaveEvent.setId(leaveRequest.getId());
        requestedLeaveEvent.setLeaveTypeId(leaveRequest.getLeaveType().getId());
        requestedLeaveEvent.setLeaveStart(leaveRequest.getLeaveStart());
        requestedLeaveEvent.setReturnDate(leaveRequest.getReturnDate());
        requestedLeaveEvent.setBudgetYearId(leaveRequest.getBudgetYear().getId());
        requestedLeaveEvent.setEmployeeId(leaveRequest.getEmployeeId());
        requestedLeaveEvent.setDay(leaveRequest.getDay());
        requestedLeaveEvent.setNumberOfDays(leaveRequest.getNumberOfDays());
        requestedLeaveEvent.setDescription(leaveRequest.getDescription());
        requestedLeaveEvent.setTenantId(leaveRequest.getTenantId());
        requestedLeaveEvent.setCreatedAt(leaveRequest.getCreatedAt());
        requestedLeaveEvent.setUpdatedAt(leaveRequest.getUpdatedAt());
        requestedLeaveEvent.setCreatedBy(leaveRequest.getCreatedBy());
        requestedLeaveEvent.setUpdatedBy(leaveRequest.getUpdatedBy());

        return requestedLeaveEvent;
    }

    public ApprovedLeaveEvent mapToApprovedLeave(LeaveRequest leaveRequest) {

        ApprovedLeaveEvent approvedLeaveEvent = new ApprovedLeaveEvent();
        approvedLeaveEvent.setId(leaveRequest.getId());
        approvedLeaveEvent.setLeaveTypeId(leaveRequest.getLeaveType().getId());
        approvedLeaveEvent.setLeaveStart(leaveRequest.getLeaveStart());
        approvedLeaveEvent.setReturnDate(leaveRequest.getReturnDate());
        approvedLeaveEvent.setBudgetYearId(leaveRequest.getBudgetYear().getId());
        approvedLeaveEvent.setEmployeeId(leaveRequest.getEmployeeId());
        approvedLeaveEvent.setDay(leaveRequest.getDay());
        approvedLeaveEvent.setNumberOfDays(leaveRequest.getNumberOfDays());
        approvedLeaveEvent.setDescription(leaveRequest.getDescription());
        approvedLeaveEvent.setTenantId(leaveRequest.getTenantId());
        approvedLeaveEvent.setCreatedAt(leaveRequest.getCreatedAt());
        approvedLeaveEvent.setUpdatedAt(leaveRequest.getUpdatedAt());
        approvedLeaveEvent.setCreatedBy(leaveRequest.getCreatedBy());
        approvedLeaveEvent.setUpdatedBy(leaveRequest.getUpdatedBy());
        approvedLeaveEvent.setNumberOfApprovedDays(leaveRequest.getNumberOfApprovedDays());
        approvedLeaveEvent.setDepartmentDecision(
                leaveRequest.getDepartmentDecision().name());
        approvedLeaveEvent.setHrDecision(leaveRequest.getHrDecision().name());
        approvedLeaveEvent.setComment(leaveRequest.getComment());

        return approvedLeaveEvent;
    }

    public RejectedLeaveEvent mapToRejectedLeave(LeaveRequest leaveRequest) {

        RejectedLeaveEvent rejectedLeaveEvent = new RejectedLeaveEvent();
        rejectedLeaveEvent.setId(leaveRequest.getId());
        rejectedLeaveEvent.setLeaveTypeId(leaveRequest.getLeaveType().getId());
        rejectedLeaveEvent.setLeaveStart(leaveRequest.getLeaveStart());
        rejectedLeaveEvent.setReturnDate(leaveRequest.getReturnDate());
        rejectedLeaveEvent.setBudgetYearId(leaveRequest.getBudgetYear().getId());
        rejectedLeaveEvent.setEmployeeId(leaveRequest.getEmployeeId());
        rejectedLeaveEvent.setDay(leaveRequest.getDay());
        rejectedLeaveEvent.setNumberOfDays(leaveRequest.getNumberOfDays());
        rejectedLeaveEvent.setDescription(leaveRequest.getDescription());
        rejectedLeaveEvent.setTenantId(leaveRequest.getTenantId());
        rejectedLeaveEvent.setCreatedAt(leaveRequest.getCreatedAt());
        rejectedLeaveEvent.setUpdatedAt(leaveRequest.getUpdatedAt());
        rejectedLeaveEvent.setCreatedBy(leaveRequest.getCreatedBy());
        rejectedLeaveEvent.setUpdatedBy(leaveRequest.getUpdatedBy());
        rejectedLeaveEvent.setDepartmentDecision(
                leaveRequest.getDepartmentDecision().name());
        rejectedLeaveEvent.setHrDecision(leaveRequest.getHrDecision().name());
        rejectedLeaveEvent.setComment(leaveRequest.getComment());

        return rejectedLeaveEvent;
    }

    public CancelledLeaveEvent mapToCancelledLeave(LeaveRequest leaveRequest) {

        CancelledLeaveEvent cancelledLeaveEvent = new CancelledLeaveEvent();
        cancelledLeaveEvent.setId(leaveRequest.getId());
        cancelledLeaveEvent.setLeaveTypeId(leaveRequest.getLeaveType().getId());
        cancelledLeaveEvent.setLeaveStart(leaveRequest.getLeaveStart());
        cancelledLeaveEvent.setReturnDate(leaveRequest.getReturnDate());
        cancelledLeaveEvent.setBudgetYearId(leaveRequest.getBudgetYear().getId());
        cancelledLeaveEvent.setEmployeeId(leaveRequest.getEmployeeId());
        cancelledLeaveEvent.setDay(leaveRequest.getDay());
        cancelledLeaveEvent.setNumberOfDays(leaveRequest.getNumberOfDays());
        cancelledLeaveEvent.setDescription(leaveRequest.getDescription());
        cancelledLeaveEvent.setTenantId(leaveRequest.getTenantId());
        cancelledLeaveEvent.setCreatedAt(leaveRequest.getCreatedAt());
        cancelledLeaveEvent.setUpdatedAt(leaveRequest.getUpdatedAt());
        cancelledLeaveEvent.setCreatedBy(leaveRequest.getCreatedBy());
        cancelledLeaveEvent.setUpdatedBy(leaveRequest.getUpdatedBy());

        return cancelledLeaveEvent;
    }
}
