package com.saas.training.repository;

import com.saas.training.model.CheckedDocument;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckedDocumentRepository extends JpaRepository<CheckedDocument, UUID> {

    boolean existsByTenantIdAndDocumentName(UUID tenantId, String documentName);

    boolean existsByTenantIdAndDocumentNameAndIdNot(UUID tenantId, String documentName, UUID id);
}
