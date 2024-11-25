package com.saas.recruitment.repository;

import com.saas.recruitment.enums.RecruitmentMode;
import com.saas.recruitment.enums.RecruitmentStatus;
import com.saas.recruitment.model.Recruitment;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruitmentRepository extends JpaRepository<Recruitment, UUID> {
    Optional<Recruitment> findByVacancyNumber(String vacancyNumber);

    List<Recruitment> findByRecruitmentStatus(RecruitmentStatus recruitmentStatus);

    List<Recruitment> findByRecruitmentMode(RecruitmentMode recruitmentMode);
}
