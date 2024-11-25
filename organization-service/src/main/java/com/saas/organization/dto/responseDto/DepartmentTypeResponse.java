package com.saas.organization.dto.responseDto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentTypeResponse {
    private UUID id;
    private String departmentTypeName;

    @NotBlank(message = "description cannot be blank")
    @Column(name = "description", nullable = false)
    private String description;

    private UUID tenantId;
}
