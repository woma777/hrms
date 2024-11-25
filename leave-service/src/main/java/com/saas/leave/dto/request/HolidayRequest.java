package com.saas.leave.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HolidayRequest {
    @NotBlank(message = "Holiday name is required")
    @Size(max = 255, message = "Holiday name cannot exceed 255 characters")
    private String holidayName;
}
