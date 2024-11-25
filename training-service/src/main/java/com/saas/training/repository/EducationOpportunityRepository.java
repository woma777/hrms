package com.saas.training.repository;

import com.saas.training.model.EducationOpportunity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationOpportunityRepository extends JpaRepository<EducationOpportunity, UUID> {

    List<EducationOpportunity> findByTenantIdAndEmployeeId(UUID tenantId, UUID employeeId);

    boolean existsByTenantIdAndBudgetYearIdAndEmployeeId(UUID tenantId, UUID budgetYearId, UUID employeeId);

    boolean existsByTenantIdAndBudgetYearIdAndEmployeeIdAndIdNot(
            UUID tenantId, UUID budgetYearId, UUID employeeId, UUID id);
}
