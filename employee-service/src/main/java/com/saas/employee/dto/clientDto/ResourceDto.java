package com.saas.employee.dto.clientDto;

import com.saas.employee.dto.response.BaseResponse;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDto extends BaseResponse {

    private UUID id;
    private String resourceName;
    private String ServiceName;
    private Set<String> requiredRoles;
    private String description;
}