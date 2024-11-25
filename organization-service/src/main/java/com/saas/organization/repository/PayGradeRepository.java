package com.saas.organization.repository;

import com.saas.organization.model.PayGrade;
import feign.Param;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PayGradeRepository extends JpaRepository<PayGrade, UUID> {
    boolean existsBySalaryStep(Integer salaryStep);

    @Query("SELECT p FROM PayGrade p WHERE p.jobGrade.id = :jobGradeId")
    List<PayGrade> findByJobGradeId(@Param("jobGradeId") UUID jobGradeId);

    boolean existsBySalaryStepAndTenantId(Integer salaryStep, UUID tenantId);

    //    boolean existsByPayGrade(String payGrade);
}
