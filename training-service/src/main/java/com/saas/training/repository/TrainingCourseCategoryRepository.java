package com.saas.training.repository;

import com.saas.training.model.TrainingCourseCategory;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingCourseCategoryRepository extends JpaRepository<TrainingCourseCategory, UUID> {

    boolean existsByTenantIdAndCategoryName(UUID tenantId, String categoryName);

    boolean existsByTenantIdAndCategoryNameAndIdNot(UUID tenantId, String categoryName, UUID id);
}
