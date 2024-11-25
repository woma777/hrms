package com.saas.organization.dto.responseDto;

import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WorkUnitResponse {
    private UUID id;
    private String workUnitName;
    private String description;
    private UUID tenantId;
}
