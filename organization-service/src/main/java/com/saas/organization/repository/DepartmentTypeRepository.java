package com.saas.organization.repository;

import com.saas.organization.model.DepartmentType;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentTypeRepository extends JpaRepository<DepartmentType, UUID> {
    Optional<DepartmentType> findByTenantId(UUID tenantId);

    boolean existsByDepartmentTypeName(String departmentTypeName);

    boolean existsByDepartmentTypeNameAndTenantId(String departmentTypeName, UUID tenantId);
}
