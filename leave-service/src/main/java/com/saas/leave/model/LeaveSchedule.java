package com.saas.leave.model;

import com.saas.leave.enums.LeaveMonth;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveSchedule extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull private UUID employeeId;

    @Enumerated(EnumType.STRING)
    @Column(name = "leaveMonth")
    @NotNull private LeaveMonth leaveMonth;

    @Size(max = 1000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "budgetYear_id")
    private BudgetYear budgetYear;

    private UUID tenantId;
}
