package com.saas.organization.repository;

import com.saas.organization.model.StaffPlan;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffPlanRepository extends JpaRepository<StaffPlan, UUID> {
    List<StaffPlan> findByDepartmentId(UUID departmentId);

    boolean existsByTenantId(UUID tenantId);
}
