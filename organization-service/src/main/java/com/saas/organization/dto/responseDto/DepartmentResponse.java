package com.saas.organization.dto.responseDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponse {
    private UUID id;
    private String departmentName;
    private UUID departmentTypeId;
    private LocalDate establishedDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
    private UUID tenantId;
    private UUID parentDepartmentId;
    private List<UUID> subDepartmentIds;
}
