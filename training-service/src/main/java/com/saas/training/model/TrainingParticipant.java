package com.saas.training.model;

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
public class TrainingParticipant extends Base {

    @NotNull @Column(nullable = false)
    private UUID participantEmployeeId;

    @Size(max = 250)
    private String reason;

    @ManyToOne()
    @JoinColumn(name = "training_id", nullable = false)
    private Training training;
}
