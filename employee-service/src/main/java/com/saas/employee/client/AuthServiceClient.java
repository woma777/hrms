package com.saas.employee.client;

import com.saas.employee.dto.clientDto.ResourceDto;
import com.saas.employee.dto.clientDto.UserDto;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "auth-service", path = "/api/auth")
public interface AuthServiceClient {

    @GetMapping("/resources/{tenantId}/get/resource-name")
    ResourceDto getResourceByName(@PathVariable UUID tenantId,
                                  @RequestParam String resourceName);

    @PostMapping("/users/{tenantId}/add")
    UserDto createUser(@PathVariable UUID tenantId,
                       @RequestParam String employeeId);

    @PutMapping("/users/{tenantId}//update/{user-id}")
    UserDto updateUser(@PathVariable UUID tenantId,
                       @PathVariable("user-id") String userId,
                       @RequestParam String employeeId);

    @GetMapping("/users/{tenantId}/get/username")
    UserDto getUserByUsername(@PathVariable UUID tenantId,
                              @RequestParam String username);

    @GetMapping("/users/{tenantId}/get/{user-id}")
    UserDto getUserById(@PathVariable UUID tenantId,
                        @PathVariable("user-id") String userId);

    @DeleteMapping("/users/{tenantId}/delete/{user-id}")
    String deleteUser(@PathVariable UUID tenantId,
                      @PathVariable("user-id") String userId);
}
