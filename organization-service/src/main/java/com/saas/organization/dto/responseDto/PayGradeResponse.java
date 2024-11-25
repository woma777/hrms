package com.saas.organization.dto.responseDto;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayGradeResponse {
    private UUID id;
    private UUID jobGradeId;
    private Double initialSalary;
    private Double maximumSalary;
    private Integer salaryStep;
    private Double salary;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
    private UUID tenantId;
}