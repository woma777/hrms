package com.saas.organization.dto.responseDto;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {
    private UUID id;
    private String blockNo;
    private String floor;
    private String officeNumber;
    private String officeTelephone;
    private String mobileNumber;
    private String email;
    private String website;
    private String poBox;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
    private UUID tenantId;
    private UUID locationId;
    private UUID departmentId;
}
