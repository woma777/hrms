package com.saas.leave.dto.request;

import com.saas.leave.enums.LeaveMonth;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveScheduleRequest {
    private UUID employeeId;
    private LeaveMonth leaveMonth;
    private String description;
}
