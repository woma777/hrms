package com.saas.leave.repository;

import com.saas.leave.model.LeaveType;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveTypeRepository extends JpaRepository<LeaveType, UUID> {

    boolean existsByLeaveTypeNameAndTenantId(String budgetYear, UUID tenantId);
}
