package com.saas.recruitment.repository;

import com.saas.recruitment.model.Applicant;
import com.saas.recruitment.model.Language;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, UUID> {

    List<Language> findByTenantIdAndApplicant(UUID tenantId, Applicant applicant);
}
