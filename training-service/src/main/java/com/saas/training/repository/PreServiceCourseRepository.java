package com.saas.training.repository;

import com.saas.training.model.PreServiceCourse;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreServiceCourseRepository extends JpaRepository<PreServiceCourse, UUID> {

    boolean existsByTenantIdAndCourseName(UUID tenantId, String courseName);

    boolean existsByTenantIdAndCourseNameAndIdNot(UUID tenantId, String courseName, UUID id);

    List<PreServiceCourse> findByTenantIdAndPreServiceTraineesId(UUID tenantId, UUID traineeId);

    List<PreServiceCourse> findByTenantIdAndPreServiceCourseTypeId(UUID tenantId, UUID courseTypeId);
}