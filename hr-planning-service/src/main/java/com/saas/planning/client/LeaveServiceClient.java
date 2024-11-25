package com.saas.planning.client;

import com.saas.planning.dto.BudgetYearDto;
import java.util.List;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "leave-service", path = "/api/leave")
public interface LeaveServiceClient {

    @GetMapping("/budget-years/{tenantId}/get/{id}")
    BudgetYearDto getBudgetYearById(@PathVariable("tenantId") UUID tenantId, @PathVariable UUID id);

    @GetMapping("/budget-years/{tenantId}/get-all")
    List<BudgetYearDto> getAllBudgetYears(@PathVariable("tenantId") UUID tenantId);
}
