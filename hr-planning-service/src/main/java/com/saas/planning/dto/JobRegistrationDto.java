package com.saas.planning.dto;

import com.saas.planning.enums.JobType;
import com.saas.planning.enums.ReportsTo;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobRegistrationDto {
    private UUID id;
    private String jobTitle;
    private String jobCode;
    private ReportsTo reportsTo;
    private JobType jobType;
    private Integer minExperience;
    private String duties;
    private String language;
    private String skills;
    private String description;
    private String alternativeExperience;
    private String relativeExperience;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
    private UUID tenantId;
    private UUID departmentId;
    private UUID educationLevelId;
    private UUID jobCategoryId;
    private UUID jobGradeId;
    private UUID workUnitId;
    private UUID qualificationId;
}