package com.saas.organization.dto.responseDto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationLevelResponse {
    private UUID id;
    private String educationLevelName;
    private String description;
    private UUID tenantId;
}
