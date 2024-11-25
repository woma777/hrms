package com.saas.recruitment.repository;

import com.saas.recruitment.model.Applicant;
import com.saas.recruitment.model.ExamResult;
import com.saas.recruitment.model.Recruitment;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamResultRepository extends JpaRepository<ExamResult, UUID> {

    ExamResult findByApplicantId(UUID applicantId);

    boolean existsByTenantIdAndApplicant(UUID tenantId, Applicant applicant);

    List<ExamResult> findByTenantIdAndRecruitment(UUID tenantId, Recruitment recruitment);
}