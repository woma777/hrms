package com.saas.organization.dto.requestDto;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.*;

@Setter
@Getter
@Data
public class StaffPlanRequest {

    @NotNull(message = "Quantity cannot be null") private Integer quantity;

    private UUID jobRegistrationId;
    private UUID departmentId;
}
