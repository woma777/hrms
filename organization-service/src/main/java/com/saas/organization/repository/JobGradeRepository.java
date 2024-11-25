package com.saas.organization.repository;

import com.saas.organization.model.JobGrade;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobGradeRepository extends JpaRepository<JobGrade, UUID> {
    boolean existsByJobGradeName(String jobGradeName);

    boolean existsByJobGradeNameAndTenantId(String jobGradeName, UUID tenantId);
}
