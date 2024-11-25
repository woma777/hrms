package com.saas.recruitment.client;

import com.saas.recruitment.dto.clientDto.CountryDto;
import com.saas.recruitment.dto.clientDto.EmployeeDto;
import com.saas.recruitment.dto.clientDto.LanguageNameDto;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "employee-service", path = "/api/employee")
public interface EmployeeServiceClient {

    @GetMapping("/employees/{tenant-id}/get")
    EmployeeDto getEmployeeByEmployeeId(
            @PathVariable("tenant-id") UUID tenantId,
            @RequestParam("employee-id") String employeeId);

    @GetMapping("/language-names/{tenant-id}/get/{language-id}")
    LanguageNameDto getLanguageName(
            @PathVariable("tenant-id") UUID tenantId,
            @PathVariable("language-id") UUID languageId);

    @GetMapping("/countries/{tenantId}/get/{countryId}")
    CountryDto getCountryById(@PathVariable UUID tenantId,
                              @PathVariable UUID countryId);
}
