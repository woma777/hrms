package com.saas.training.dto.clientDto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QualificationDto {
    private UUID id;
    private String qualification;
    private String description;
    private UUID tenantId;
}
