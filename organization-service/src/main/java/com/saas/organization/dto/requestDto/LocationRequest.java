package com.saas.organization.dto.requestDto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationRequest {
    private String locationName;

    private UUID locationTypeId;
    private UUID tenantId;
}
