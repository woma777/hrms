package com.saas.training.dto.response;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingInstitutionResponse extends BaseResponse {

    private String institutionName;
    private UUID locationId;
    private Double costPerPerson;
    private String phoneNumber;
    private String email;
    private String fax;
    private String website;
    private String tinNumber;
    private String remark;
}