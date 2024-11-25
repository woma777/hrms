package com.saas.leave.dto.response;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HolidayResponse {
    private UUID id;
    private String holidayName;
    private UUID tenantId;
}
