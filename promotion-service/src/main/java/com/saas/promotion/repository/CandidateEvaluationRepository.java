package com.saas.promotion.repository;

import com.saas.promotion.model.CandidateEvaluation;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateEvaluationRepository extends JpaRepository<CandidateEvaluation, UUID> {

    List<CandidateEvaluation> findByTenantIdAndCandidateId(UUID tenantId, UUID candidateId);

    boolean existsByTenantIdAndCandidateIdAndPromotionCriteriaId(UUID tenantId, UUID candidateId, UUID criteria);
}