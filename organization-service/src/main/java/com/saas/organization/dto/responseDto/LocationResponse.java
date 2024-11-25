package com.saas.organization.dto.responseDto;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationResponse {
    private UUID id;
    private String locationName;
    private UUID parentLocationId;
    private List<UUID> subLocationIds;
    private UUID locationTypeId;
    private UUID tenantId;
}
