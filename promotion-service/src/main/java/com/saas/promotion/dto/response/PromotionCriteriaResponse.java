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
public class PromotionCriteriaResponse extends BaseResponse {

    private CriteriaNameResponse criteriaName;
    private double weight;
    private UUID parentCriteriaId;
}