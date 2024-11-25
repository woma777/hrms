package com.saas.leave.dto.response;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BudgetYearResponse {
    private UUID id;
    private String budgetYear;
    private boolean isActive;
    private String description;
    private UUID tenantId;
}
