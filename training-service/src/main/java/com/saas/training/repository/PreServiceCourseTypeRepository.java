package com.saas.training.repository;

import com.saas.training.model.PreServiceCourseType;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreServiceCourseTypeRepository extends JpaRepository<PreServiceCourseType, UUID> {

    boolean existsByTenantIdAndCourseType(UUID tenantId, String courseType);

    boolean existsByTenantIdAndCourseTypeAndIdNot(UUID tenantId, String courseType, UUID id);
}
