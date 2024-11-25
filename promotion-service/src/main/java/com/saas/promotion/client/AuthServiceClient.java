package com.saas.promotion.client;

import com.saas.promotion.dto.clientDto.ResourceDto;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "auth-service", path = "/api/auth")
public interface AuthServiceClient {

    @GetMapping("/resources/{tenantId}/get/resource-name")
    ResourceDto getResourceByName(@PathVariable UUID tenantId,
                                  @RequestParam String resourceName);
}
