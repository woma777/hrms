package com.saas.organization.repository;

import com.saas.organization.model.Tenant;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, UUID> {

    boolean existsByTenantName(String tenantName);

    boolean existsByTenantNameAndIdNot(String tenantName, UUID tenantId);

    boolean existsByAbbreviatedName(String abbreviatedName);

    boolean existsByAbbreviatedNameAndIdNot(String abbreviatedName, UUID tenantId);
}
