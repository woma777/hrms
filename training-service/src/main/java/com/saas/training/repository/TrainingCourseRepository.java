package com.saas.training.repository;

import com.saas.training.model.TrainingCourse;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingCourseRepository extends JpaRepository<TrainingCourse, UUID> {

    boolean existsByTenantIdAndCourseName(UUID tenantId, String courseName);

    boolean existsByTenantIdAndCourseNameAndIdNot(UUID tenantId, String courseName, UUID id);
}
