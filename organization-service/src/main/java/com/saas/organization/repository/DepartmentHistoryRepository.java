package com.saas.organization.repository;

import com.saas.organization.model.DepartmentHistory;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentHistoryRepository extends JpaRepository<DepartmentHistory, UUID> {
    Optional<DepartmentHistory> findByTenantId(UUID tenantId);
}
