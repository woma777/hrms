package com.saas.auth.dto.request;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceRequest {

    private String resourceName;
    private String ServiceName;
    private String description;
    private Set<String> requiredRoles;
}
