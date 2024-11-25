package com.saas.employee.dto.response;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationResponse extends BaseResponse {
    private UUID educationLevelId;
    private String educationType;
    private UUID fieldOfStudyId;
    private String institution;
    private LocalDate startDate;
    private LocalDate endDate;
    private String award;
    private Double result;
    private String fileName;
    private String fileType;
    private byte[] fileBytes;
    private UUID employeeId;
}
