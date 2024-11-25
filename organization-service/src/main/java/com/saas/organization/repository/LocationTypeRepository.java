package com.saas.organization.repository;

import com.saas.organization.model.LocationType;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationTypeRepository extends JpaRepository<LocationType, UUID> {
    boolean existsByLocationTypeNameAndTenantId(String locationTypeName, UUID tenantId);

    boolean existsByLocationTypeNameAndTenantIdAndIdNot(String locationTypeName, UUID tenantId, UUID id);
}
