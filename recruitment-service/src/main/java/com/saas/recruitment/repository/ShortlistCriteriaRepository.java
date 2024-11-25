package com.saas.recruitment.repository;

import com.saas.recruitment.model.Recruitment;
import com.saas.recruitment.model.ShortlistCriteria;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortlistCriteriaRepository extends JpaRepository<ShortlistCriteria, UUID> {

    List<ShortlistCriteria> findByTenantIdAndRecruitment(UUID tenantId, Recruitment recruitment);
}
