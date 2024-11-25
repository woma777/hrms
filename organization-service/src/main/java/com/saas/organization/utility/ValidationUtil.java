package com.saas.organization.utility;

import com.saas.organization.exception.ResourceNotFoundException;
import com.saas.organization.model.Tenant;
import com.saas.organization.repository.TenantRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidationUtil {

    private final TenantRepository tenantRepository;

    public Tenant getTenantById(UUID tenantId) {

        return tenantRepository
                .findById(tenantId)
                .orElseThrow(() -> new ResourceNotFoundException("Tenant not found with id '" + tenantId + "'"));
    }
}