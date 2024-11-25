package com.saas.training.repository;

import com.saas.training.model.University;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University, UUID> {

    boolean existsByTenantIdAndUniversityName(UUID tenantId, String universityName);

    boolean existsByTenantIdAndUniversityNameAndIdNot(UUID tenantId, String universityName, UUID id);
}
