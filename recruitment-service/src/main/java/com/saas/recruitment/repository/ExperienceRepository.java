package com.saas.recruitment.repository;

import com.saas.recruitment.model.Applicant;
import com.saas.recruitment.model.Experience;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience, UUID> {

    List<Experience> findByTenantIdAndApplicant(UUID tenantId, Applicant applicant);
}
