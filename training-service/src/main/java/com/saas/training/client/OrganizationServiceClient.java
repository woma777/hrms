package com.saas.training.client;

import com.saas.training.dto.clientDto.*;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "organization-service", path = "/api/organization")
public interface OrganizationServiceClient {

    @GetMapping("/tenants/get/{id}")
    TenantDto getTenantById(@PathVariable UUID id);

    @GetMapping("/locations/{tenant-id}/get/{id}")
    LocationDto getLocationById(@PathVariable UUID id,
                                @PathVariable("tenant-id") UUID tenantId);

    @GetMapping("/departments/{tenant-id}/get/{id}")
    DepartmentDto getDepartmentById(@PathVariable UUID id,
                                    @PathVariable("tenant-id") UUID tenantId);

    @GetMapping("/field-of-studies/{tenant-id}/get/{id}")
    FieldOfStudyDto getFieldOfStudyById(@PathVariable UUID id,
                                        @PathVariable("tenant-id") UUID tenantId);

    @GetMapping("/education-levels/{tenant-id}/get/{id}")
    EducationLevelDto getEducationLevelById(@PathVariable UUID id,
                                            @PathVariable("tenant-id") UUID tenantId);

    @GetMapping("/qualifications/{tenantId}/get/{id}")
    QualificationDto getQualificationById(@PathVariable UUID id,
                                          @PathVariable("tenantId") UUID tenantId);
}
