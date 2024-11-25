package com.saas.planning.client;

import com.saas.planning.dto.*;
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

    @GetMapping("/job-registrations/{tenant-id}/get/{id}")
    JobRegistrationDto getJobById(@PathVariable UUID id, @PathVariable("tenant-id") UUID tenantId);

    @GetMapping("/api/organization/staff-plans/{tenant-id}/get/{id}")
    StaffPlanDto getStaffPlanById(@PathVariable UUID id, @PathVariable("tenant-id") UUID tenantId);

    @GetMapping("/api/organization/work-units/{tenantId}/get/{id}")
    WorkUnitDto getWorkUnitById(@PathVariable UUID id, @PathVariable("tenantId") UUID tenantId);
}
