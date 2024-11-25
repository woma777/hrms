package com.saas.leave.repository;

import com.saas.leave.model.LeaveBalanceHistory;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveBalanceHistoryRepository extends JpaRepository<LeaveBalanceHistory, UUID> {
    List<LeaveBalanceHistory> findByEmployeeId(UUID employeeId);
}
