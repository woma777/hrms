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
public class PromoteCandidateResponse extends BaseResponse {

    private UUID payGradeId;
    private CandidateResponse candidate;
}
