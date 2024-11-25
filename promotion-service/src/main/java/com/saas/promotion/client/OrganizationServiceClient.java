package com.saas.promotion.client;

import com.saas.promotion.dto.clientDto.*;
import java.util.List;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "organization-service", path = "/api/organization")
public interface OrganizationServiceClient {

    @GetMapping("/tenants/get/{id}")
    TenantDto getTenantById(@PathVariable UUID id);

    @GetMapping("/job-registrations/{tenant-id}/get/{id}")
    JobDto getJobById(@PathVariable UUID id,
                      @PathVariable("tenant-id") UUID tenantId);

    @GetMapping("/pay-grades/{tenant-id}/get/{id}")
    PayGradeDto getPayGradeById(@PathVariable UUID id,
                                @PathVariable("tenant-id") UUID tenantId);

    @GetMapping("/pay-grades/{tenant-id}/jobgrade/{jobGradeId}")
    List<PayGradeDto> getPayGradesByJobGradeId(@PathVariable UUID jobGradeId,
                                               @PathVariable("tenant-id") UUID tenantId);
}
