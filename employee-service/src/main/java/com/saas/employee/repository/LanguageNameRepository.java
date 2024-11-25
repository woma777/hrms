package com.saas.employee.repository;

import com.saas.employee.model.LanguageName;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageNameRepository extends JpaRepository<LanguageName, UUID> {

    boolean existsByLanguageNameAndTenantId(String languageName, UUID tenantId);

    boolean existsByTenantIdAndLanguageNameAndIdNot(UUID tenantId, String languageName, UUID id);
}
