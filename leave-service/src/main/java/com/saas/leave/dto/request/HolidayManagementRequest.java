package com.saas.leave.dto.request;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HolidayManagementRequest {
    private UUID budgetYearId;
    private LocalDate date;
    private UUID holidayId;
}
