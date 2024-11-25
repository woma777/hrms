package com.saas.employee.dto.clientDto;

import com.saas.employee.dto.response.BaseResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto extends BaseResponse {
    private UUID id;
    private String departmentName;
    private UUID departmentTypeId;
    private LocalDate establishedDate;
    private UUID parentDepartmentId;
    private List<UUID> subDepartmentIds;
}