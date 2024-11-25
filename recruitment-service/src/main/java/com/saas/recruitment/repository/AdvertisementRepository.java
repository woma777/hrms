package com.saas.recruitment.repository;

import com.saas.recruitment.model.Advertisement;
import com.saas.recruitment.model.Recruitment;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementRepository extends JpaRepository<Advertisement, UUID> {

    Advertisement findByRecruitmentId(UUID recruitmentId);

    boolean existsByTenantIdAndRecruitment(UUID tenantId, Recruitment recruitment);
}