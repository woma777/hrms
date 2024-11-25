package com.saas.leave.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.Instant;
import lombok.Data;

@Entity
@Data
public class Shedlock {

    @Id
    private String name;

    private Instant lockUntil;
    private Instant lockedAt;
    private String lockedBy;
}
