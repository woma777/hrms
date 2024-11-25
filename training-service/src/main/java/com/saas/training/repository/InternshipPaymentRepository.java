package com.saas.training.repository;

import com.saas.training.model.InternshipPayment;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternshipPaymentRepository extends JpaRepository<InternshipPayment, UUID> {

    boolean existsByTenantIdAndInternshipStudentId(UUID tenantId, UUID internId);

    boolean existsByTenantIdAndInternshipStudentIdAndIdNot(UUID tenantId, UUID internId, UUID id);
}
