package com.saas.leave.dto.response;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HolidayManagementResponse {
    private UUID id;
    private UUID budgetYearId;
    private UUID holidayId;
    private LocalDate date;
    private UUID tenantId;
}
