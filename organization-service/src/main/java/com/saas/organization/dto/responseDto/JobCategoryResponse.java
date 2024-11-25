package com.saas.organization.dto.responseDto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobCategoryResponse {
    private UUID id;
    private String jobCategoryName;
    private String description;
    private UUID tenantId;
}
