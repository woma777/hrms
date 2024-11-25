package com.saas.planning.dto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkUnitDto {
    private UUID id;
    private String workUnitName;
    private String description;
    private UUID tenantId;
}
