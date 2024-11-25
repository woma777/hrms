package com.saas.training.repository;

import com.saas.training.enums.TrainingStatus;
import com.saas.training.model.Training;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<Training, UUID> {

    List<Training> findByTenantIdAndTrainingStatus(UUID tenantId, TrainingStatus trainingStatus);
}
