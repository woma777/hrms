package com.saas.leave.repository;

import com.saas.leave.model.LeaveSchedule;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveScheduleRepository extends JpaRepository<LeaveSchedule, UUID> {

    boolean existsByTenantId(UUID tenantId);

    boolean existsByEmployeeId(UUID employeeId);
}
