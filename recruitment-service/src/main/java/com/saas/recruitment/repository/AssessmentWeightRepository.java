package com.saas.recruitment.repository;

import com.saas.recruitment.model.AssessmentWeight;
import com.saas.recruitment.model.Recruitment;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentWeightRepository extends JpaRepository<AssessmentWeight, UUID> {

    Optional<AssessmentWeight> findByRecruitmentId(UUID recruitmentId);

    boolean existsByTenantIdAndRecruitment(UUID tenantId, Recruitment recruitment);
}
