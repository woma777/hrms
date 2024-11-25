package com.saas.notification.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "notifications")
public record ApplicationProperties(
        String leaveEventsExchange,
        String requestedLeavesQueue,
        String approvedLeavesQueue,
        String rejectedLeavesQueue,
        String cancelledLeavesQueue,
        String requestedLeavesRoutingKey,
        String approvedLeavesRoutingKey,
        String rejectedLeavesRoutingKey,
        String cancelledLeavesRoutingKey) {}
