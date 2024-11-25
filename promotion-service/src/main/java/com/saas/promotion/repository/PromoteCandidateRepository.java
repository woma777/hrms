package com.saas.promotion.repository;

import com.saas.promotion.model.PromoteCandidate;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromoteCandidateRepository extends JpaRepository<PromoteCandidate, UUID> {

    List<PromoteCandidate> findByTenantId(UUID tenantId);

    boolean existsByTenantIdAndCandidateId(UUID tenantId, UUID candidateId);
}
