package com.saas.planning.dto.response;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HrAnalysisResponseDto {
    private UUID id;
    private UUID budgetYearId;
    private UUID workUnitId;
    private UUID jobRegistrationId;
    private UUID tenantId;
    private UUID hrNeedRequestId; // Reference to HrNeedRequest
    private LocalDate analysedOn;
    private LocalDate processedDate;
    private String processedBy;
    private String comment;
}
