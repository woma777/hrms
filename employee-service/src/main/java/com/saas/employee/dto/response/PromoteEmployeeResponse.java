package com.saas.employee.dto.response;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoteEmployeeResponse extends BaseResponse {

    private UUID employeeId;
    private UUID departmentId;
    private UUID jobId;
    private UUID payGradeId;
}
