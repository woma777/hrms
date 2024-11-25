package com.saas.organization.repository;

import com.saas.organization.model.JobCategory;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobCategoryRepository extends JpaRepository<JobCategory, UUID> {
    boolean existsByJobCategoryName(String jobCategoryName);

    boolean existsByJobCategoryNameAndTenantId(String jobCategoryName, UUID tenantId);
}
