package com.saas.recruitment.repository;

import com.saas.recruitment.model.Applicant;
import com.saas.recruitment.model.Education;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, UUID> {

    List<Education> findByTenantIdAndApplicant(UUID tenantId, Applicant applicant);
}
