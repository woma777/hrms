package com.saas.planning.repository;

import com.saas.planning.model.HrAnalysis;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HrAnalysisRepository extends JpaRepository<HrAnalysis, UUID> {
    // Add any custom query methods if necessary
}
