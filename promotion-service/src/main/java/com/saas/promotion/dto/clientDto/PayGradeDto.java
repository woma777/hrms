package com.saas.promotion.dto.clientDto;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayGradeDto {
    private UUID id;
    private String payGrade;
    private Double initialSalary;
    private Double maximumSalary;
    private Integer salaryStep;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
    private UUID tenantId;
}
