package com.saas.training.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InternshipPlacementRequest {

    @NotNull(message = "Placed department Id cannot be null") private UUID placedDepartmentId;

    @Size(max = 100, message = "Remark must be less than 100 characters")
    private String remark;
}
