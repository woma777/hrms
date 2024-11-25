package com.saas.leave.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
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
public class HolidayManagement extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull @Column(nullable = false)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "budget-year_id")
    private BudgetYear budgetYear;

    @ManyToOne
    @JoinColumn(name = "holiday_id")
    private Holiday holiday;

    private UUID tenantId;

    public LocalDate getDate() {
        return date;
    }
}
