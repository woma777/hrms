package com.saas.leave.dto.event;

import com.saas.leave.enums.Day;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CancelledLeaveEvent {

    private UUID id;
    private UUID employeeId;
    private int numberOfDays;
    private LocalDate leaveStart;
    private LocalDate returnDate;
    private Day day;
    private String description;
    private UUID leaveTypeId;
    private UUID budgetYearId;
    private UUID tenantId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
}
