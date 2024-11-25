package com.saas.planning.repository;

import com.saas.planning.model.AnnualRecruitmentAndPromotion;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnualRecruitmentAndPromotionRepository extends JpaRepository<AnnualRecruitmentAndPromotion, UUID> {
    // Additional query methods (if needed) can be defined here
}
