package com.saas.recruitment.repository;

import com.saas.recruitment.model.Applicant;
import com.saas.recruitment.model.Reference;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferenceRepository extends JpaRepository<Reference, UUID> {

    List<Reference> findByTenantIdAndApplicant(UUID tenantId, Applicant applicant);
}
