package com.saas.training.repository;

import com.saas.training.model.TrainingInstitution;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingInstitutionRepository extends JpaRepository<TrainingInstitution, UUID> {
    boolean existsByTenantIdAndInstitutionName(UUID tenantId, String institutionName);

    boolean existsByTenantIdAndInstitutionNameAndIdNot(UUID tenantId, String institutionName, UUID id);
}
