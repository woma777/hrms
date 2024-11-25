package com.saas.leave.client;

import com.saas.leave.dto.DepartmentDto;
import com.saas.leave.dto.TenantDto;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "organization-service", path = "/api/organization")
public interface OrganizationServiceClient {

    @GetMapping("/tenants/get/{id}")
    TenantDto getTenantById(@PathVariable UUID id);

    @GetMapping("/departments/{tenant-id}/get/{id}")
    DepartmentDto getDepartmentById(@PathVariable UUID id, @PathVariable("tenant-id") UUID tenantId);
}
