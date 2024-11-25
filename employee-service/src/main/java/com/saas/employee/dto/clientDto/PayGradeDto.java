package com.saas.employee.dto.clientDto;

import com.saas.employee.dto.response.BaseResponse;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayGradeDto extends BaseResponse {
    private UUID id;
    private String payGrade;
    private Double initialSalary;
    private Double maximumSalary;
    private Integer salaryStep;
    private String description;
}