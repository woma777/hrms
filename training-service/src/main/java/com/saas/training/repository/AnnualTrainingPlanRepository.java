package com.saas.training.repository;

import com.saas.training.model.AnnualTrainingPlan;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnualTrainingPlanRepository extends JpaRepository<AnnualTrainingPlan, UUID> {

    boolean existsByTenantIdAndDepartmentIdAndBudgetYearIdAndTrainingCourseId(
            UUID tenantId, UUID departmentId, UUID budgetYearId, UUID trainingCourseId);

    boolean existsByTenantIdAndDepartmentIdAndBudgetYearIdAndTrainingCourseIdAndIdNot(
            UUID tenantId, UUID departmentId, UUID budgetYearId, UUID trainingCourseId, UUID id);
}