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
public class TrainingParticipantResponse extends BaseResponse {

    private UUID participantEmployeeId;
    private UUID trainingId;
    private String reason;
}
