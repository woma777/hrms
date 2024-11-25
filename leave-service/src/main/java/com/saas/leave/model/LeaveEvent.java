package com.saas.leave.model;

import com.saas.leave.enums.LeaveEventType;
import jakarta.persistence.*;
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
public class LeaveEvent extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LeaveEventType eventType;

    @Lob
    @Column(nullable = false, columnDefinition = "TEXT")
    private String payload;
}
