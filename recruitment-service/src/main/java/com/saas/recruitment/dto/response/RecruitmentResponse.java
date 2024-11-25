package com.saas.recruitment.dto.response;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecruitmentResponse extends BaseResponse {
    private UUID requesterEmployeeId;
    private UUID departmentId;
    private UUID jobId;
    private String vacancyNumber;
    private Integer numberOfEmployeesRequested;
    private Integer numberOfEmployeesApproved;
    private String recruitmentType;
    private String recruitmentMode;
    private String recruitmentStatus;
    private String remark;
}
