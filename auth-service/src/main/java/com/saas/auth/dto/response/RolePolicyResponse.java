package com.saas.auth.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolePolicyResponse {

    private String policyId;
    private String policyName;
    private List<String> roleNames;
    private String description;
}
