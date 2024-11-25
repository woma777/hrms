package com.saas.auth.repository;

import com.saas.auth.model.Resource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, UUID> {

    boolean existsByTenantIdAndResourceName(UUID tenantId, String resourceName);

    boolean existsByTenantIdAndResourceNameAndIdNot(UUID tenantId, String resourceName, UUID id);

    List<Resource> findByTenantId(UUID tenantId);

    Optional<Resource> findByTenantIdAndResourceName(UUID tenantId, String resourceName);

    List<Resource> findByTenantIdAndServiceName(UUID tenantId, String serviceName);
}
