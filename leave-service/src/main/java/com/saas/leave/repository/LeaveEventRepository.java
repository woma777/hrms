package com.saas.leave.repository;

import com.saas.leave.model.LeaveEvent;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveEventRepository extends JpaRepository<LeaveEvent, UUID> {}
