package com.saas.promotion.dto.response;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CriteriaNameResponse extends BaseResponse {

    private String name;
    private String description;
    private UUID parentCriteriaNameId;
}