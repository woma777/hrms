package com.saas.organization.dto.responseDto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobGradeResponseDto {

    private UUID id;

    private String jobGradeName;

    private String description;

    private UUID tenantId;

    // Getters and Setters

}
