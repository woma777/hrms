package com.saas.training.client;

import com.saas.training.dto.clientDto.CountryDto;
import com.saas.training.dto.clientDto.EmployeeDto;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "employee-service", path = "/api/employee")
public interface EmployeeServiceClient {

    @GetMapping("/employees/{tenant-id}/get")
    EmployeeDto getEmployeeByEmployeeId(@PathVariable("tenant-id") UUID tenantId,
                                        @RequestParam("employee-id") String employeeId);

    @GetMapping("/countries/{tenantId}/get/{countryId}")
    CountryDto getCountryById(@PathVariable UUID tenantId,
                              @PathVariable UUID countryId);

    @GetMapping("/employees/{tenant-id}/get-employee")
    EmployeeDto getEmployeeByName(@PathVariable("tenant-id") UUID tenantId,
                                  @RequestParam("first-name") String firstName,
                                  @RequestParam(value = "middle-name", required = false) String middleName,
                                  @RequestParam(value = "last-name", required = false) String lastName);
}
