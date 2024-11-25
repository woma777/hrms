package com.saas.planning.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnnualRecruitmentAndPromotionRequest {
    @NotNull(message = "Budget Year ID cannot be null") private UUID budgetYearId;

    @NotNull(message = "Work Unit ID cannot be null") private UUID workUnitId;

    @NotNull(message = "HrNeedRequest ID cannot be null") private UUID hrNeedRequestId;

    //    @NotNull(message = "Tenant ID cannot be null")
    //    private UUID tenantId;

    @NotNull(message = "Grand Total cannot be null") @Min(value = 0, message = "Grand Total must be greater than or equal to 0")
    private Integer grandTotal;

    private String remark;

    private Boolean internalRecruitment;
    private Boolean externalRecruitment;
    private Boolean all;

    @NotBlank(message = "Prepared By cannot be blank")
    private String preparedBy;

    private String comment;
}
