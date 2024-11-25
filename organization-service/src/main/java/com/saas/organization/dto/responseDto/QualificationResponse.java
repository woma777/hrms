package com.saas.organization.dto.responseDto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QualificationResponse {
    private UUID id;
    private String qualification;
    private String description;
    private UUID tenantId;
    // private UUID jobRegistrationId;

    // Getters and Setters
}
