package com.saas.organization.repository;

import com.saas.organization.model.WorkUnit;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkUnitRepository extends JpaRepository<WorkUnit, UUID> {
    boolean existsByWorkUnitNameAndTenantId(String workUnitName, UUID tenantId);
}
