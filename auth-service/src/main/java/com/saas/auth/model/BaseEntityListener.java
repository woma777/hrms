package com.saas.auth.model;

import com.saas.auth.utility.SecurityUtil;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BaseEntityListener {

    private final SecurityUtil securityUtil;

    @PrePersist
    public void setCreatedByAndUpdatedBy(Base base) {
        String name = securityUtil.getName();
        base.setCreatedBy(name != null ? name : "unknown");
        base.setUpdatedBy(null);
    }

    @PreUpdate
    public void setUpdatedBy(Base base) {
        String name = securityUtil.getName();
        base.setUpdatedBy(name != null ? name : "unknown");
    }
}
