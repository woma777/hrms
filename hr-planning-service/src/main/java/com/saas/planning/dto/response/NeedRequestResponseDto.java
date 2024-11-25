package com.saas.planning.dto.response;

import com.saas.planning.enums.EmploymentType;
import com.saas.planning.enums.HowToBeFilled;
import com.saas.planning.enums.WhenToBe;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NeedRequestResponseDto {

    private UUID id;
    private Integer noOfPosition;
    private EmploymentType employmentType;
    private HowToBeFilled howToBeFilled;
    private WhenToBe whenToBe;
    private String remark;
    private UUID budgetYearId;
    private UUID departmentId;
    private UUID staffPlanId;
    private UUID tenantId;
    private LocalDateTime createdAt;
    private String createdBy;
}
