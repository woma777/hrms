package com.saas.promotion.client;

import com.saas.promotion.dto.clientDto.EmployeeDto;
import com.saas.promotion.dto.clientDto.PromoteEmployeeResponse;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "employee-service", path = "/api/employee")
public interface EmployeeServiceClient {

    @GetMapping("/employees/{tenant-id}/get")
    EmployeeDto getEmployeeByEmployeeId(@PathVariable("tenant-id") UUID tenantId,
                                        @RequestParam("employee-id") String employeeId);

    @GetMapping("/employees/{tenant-id}/get/{employee-id}")
    EmployeeDto getEmployeeById(@PathVariable("tenant-id") UUID tenantId,
                                @PathVariable("employee-id") UUID employeeId);

    @PutMapping("/employees/{tenant-id}/add-history/{employee-id}")
    PromoteEmployeeResponse addEmployeeHistory(@PathVariable("tenant-id") UUID tenantId,
                                               @PathVariable("employee-id") UUID employeeId,
                                               @RequestParam String vacancyNumber,
                                               @RequestParam UUID payGradeId);
}
