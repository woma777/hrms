package com.saas.planning.dto.request;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HrAnalysisRequestDto {
    private UUID budgetYearId;
    private UUID workUnitId;
    private UUID jobRegistrationId;
    private UUID hrNeedRequestId;
    private String processedBy;
    private String comment;
}
