package com.saas.leave.model;

import jakarta.persistence.*;
import java.util.List;
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
public class LeaveType extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String leaveTypeName;

    @OneToMany(mappedBy = "leaveType", cascade = CascadeType.ALL)
    private List<LeaveSetting> leaveSettings;

    @OneToMany(mappedBy = "leaveType")
    private List<LeaveRequest> leaveRequests;

    private UUID tenantId;
}
