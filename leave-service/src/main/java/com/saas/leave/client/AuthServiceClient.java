package com.saas.leave.client;

import com.saas.leave.dto.ResourceDto;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "auth-service", path = "/api/auth")
public interface AuthServiceClient {

    @GetMapping("/resources/{tenantId}/get/resource-name")
    ResourceDto getResourceByName(@PathVariable UUID tenantId, @RequestParam String resourceName);
}