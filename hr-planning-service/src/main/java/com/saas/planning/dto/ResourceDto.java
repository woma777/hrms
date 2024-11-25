package com.saas.planning.dto;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDto {

    private UUID id;
    private String resourceName;
    private String ServiceName;
    private Set<String> requiredRoles;
    private String description;
    private UUID tenantId;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}
