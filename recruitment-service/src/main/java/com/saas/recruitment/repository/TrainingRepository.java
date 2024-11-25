package com.saas.recruitment.repository;

import com.saas.recruitment.model.Applicant;
import com.saas.recruitment.model.Training;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<Training, UUID> {

    List<Training> findByTenantIdAndApplicant(UUID tenantId, Applicant applicant);
}
