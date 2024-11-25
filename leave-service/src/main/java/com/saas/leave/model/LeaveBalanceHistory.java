package com.saas.leave.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "leave_balance_history")
@Data
@NoArgsConstructor // Default constructor for Hibernate
@AllArgsConstructor
public class LeaveBalanceHistory extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "employee_id", nullable = false) // Ensure this is non-null
    private UUID employeeId;

    @Column(name = "total_leave_days", nullable = false) // Ensure this is non-null
    private Integer totalLeaveDays;

    @Column(name = "remaining_leave_days", nullable = false) // Ensure this is non-null
    private int remainingDays;

    @Column(name = "tenant_id", nullable = false) // Ensure this is non-null
    private UUID tenantId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "budget_year_id", nullable = false) // Ensure this relationship is non-null
    private BudgetYear budgetYear;

    @Column(name = "calculation_date", nullable = false) // Ensure this is non-null
    private LocalDate calculationDate = LocalDate.now();
}
