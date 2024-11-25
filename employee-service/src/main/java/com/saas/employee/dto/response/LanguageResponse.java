package com.saas.employee.dto.response;

import com.saas.employee.enums.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageResponse extends BaseResponse {
    private UUID languageNameId;
    private String listening;
    private String speaking;
    private String reading;
    private String writing;
    private UUID employeeId;
}