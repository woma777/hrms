package com.saas.leave.client;

import com.saas.leave.dto.EmployeeDto;
import java.util.List;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "employee-service", path = "/api/employee")
public interface EmployeeServiceClient {

    @GetMapping("/employees/{tenant-id}/get")
    EmployeeDto getEmployeeByEmployeeId(
            @PathVariable("tenant-id") UUID tenantId, @RequestParam("employee-id") String employeeId);

    @GetMapping("/employees/{tenant-id}/get/{employee-id}")
    EmployeeDto getEmployeeById(@PathVariable("tenant-id") UUID tenantId, @PathVariable("employee-id") UUID employeeId);

    @GetMapping("/employees/{tenantId}/get-all")
    List<EmployeeDto> getAllEmployees(@PathVariable("tenantId") UUID tenantId);
}
