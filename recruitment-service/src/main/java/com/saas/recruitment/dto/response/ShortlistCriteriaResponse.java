package com.saas.recruitment.dto.response;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShortlistCriteriaResponse extends BaseResponse {
    private String criteriaName;
    private String gender;
    private UUID educationLevelId;
    private String trainingOrCertificate;
    private String experienceType;
    private Double CGPA;
    private Integer minimumExperience;
    private Integer minimumAge;
    private Integer maximumAge;
    private String other;
    private UUID recruitmentId;
}