package com.saas.recruitment.repository;

import com.saas.recruitment.model.Applicant;
import com.saas.recruitment.model.Recruitment;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant, UUID> {

    List<Applicant> findByTenantIdAndRecruitment(UUID tenantId, Recruitment recruitment);
}
