package com.saas.promotion.repository;

import com.saas.promotion.model.CriteriaName;
import com.saas.promotion.model.PromotionCriteria;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionCriteriaRepository extends JpaRepository<PromotionCriteria, UUID> {

    boolean existsByTenantIdAndCriteriaName(UUID tenantId, CriteriaName criteriaName);

    boolean existsByTenantIdAndCriteriaNameAndIdNot(UUID tenantId, CriteriaName criteriaName, UUID id);

    boolean existsByTenantIdAndParentPromotionCriteriaAndCriteriaName(
            UUID tenantId, PromotionCriteria parentCriteria, CriteriaName criteriaName);

    List<PromotionCriteria> findByTenantId(UUID tenantId);

    List<PromotionCriteria> findByTenantIdAndParentPromotionCriteria(UUID tenantId, PromotionCriteria parentCriteria);
}
