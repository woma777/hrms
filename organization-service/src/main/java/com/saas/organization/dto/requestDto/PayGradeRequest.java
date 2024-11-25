package com.saas.organization.dto.requestDto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayGradeRequest {
    private UUID jobGradeId;
    private Double initialSalary;
    private Double maximumSalary;
    private Integer salaryStep;
    private Double salary;
    private String description;
}
