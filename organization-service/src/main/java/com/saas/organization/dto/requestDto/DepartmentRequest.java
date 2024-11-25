package com.saas.organization.dto.requestDto;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentRequest {
    private String departmentName;
    private LocalDate establishedDate;
    private UUID departmentTypeId;
    //  private UUID parentDepartmentId;
    //    private UUID tenantId;
    //    private List<UUID> subDepartmentIds;

}