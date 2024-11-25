package com.saas.training.dto.response;

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
public class InternshipPaymentResponse extends BaseResponse {

    private String referenceLetter;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double paymentAmount;
    private String remark;
    private UUID internId;
}
