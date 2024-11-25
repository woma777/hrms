package com.saas.organization.repository;

import com.saas.organization.model.Address;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {
    Optional<Address> findByTenantId(UUID tenantId);

    List<Address> findByDepartmentId(UUID departmentId);

    boolean existsByDepartmentIdAndTenantId(UUID departmentId, UUID tenantId);
}
