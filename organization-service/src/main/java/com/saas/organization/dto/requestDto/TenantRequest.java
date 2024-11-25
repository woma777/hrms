package com.saas.organization.dto.requestDto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TenantRequest {
    private String tenantName;
    private String abbreviatedName;
    private String logo;
    private LocalDate establishedYear;
    private String mission;
    private String vision;
}
