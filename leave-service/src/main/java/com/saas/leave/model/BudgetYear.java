package com.saas.leave.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BudgetYear extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull(message = "Start Year is required") @Column(name = "Start Year", nullable = false)
    private String budgetYear;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Size(max = 255, message = "Description cannot exceed 255 characters")
    @Column(name = "description")
    private String description;

    @NotNull(message = "Tenant ID is required") @Column(name = "tenant_id", nullable = false)
    private UUID tenantId;

    @OneToMany(mappedBy = "budgetYear", fetch = FetchType.LAZY)
    private List<HolidayManagement> holidayManagements;

    @OneToMany(mappedBy = "budgetYear", fetch = FetchType.LAZY)
    private List<LeaveBalance> leaveBalances;

    @OneToMany(mappedBy = "budgetYear", fetch = FetchType.LAZY)
    private List<LeaveBalanceHistory> leaveBalanceHistories;

    @OneToMany(mappedBy = "budgetYear", fetch = FetchType.LAZY)
    private List<LeaveRequest> leaveRequests;
}