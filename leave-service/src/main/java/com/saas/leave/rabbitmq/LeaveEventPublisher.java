package com.saas.leave.rabbitmq;

import com.saas.leave.config.ApplicationProperties;
import com.saas.leave.dto.event.ApprovedLeaveEvent;
import com.saas.leave.dto.event.CancelledLeaveEvent;
import com.saas.leave.dto.event.RejectedLeaveEvent;
import com.saas.leave.dto.event.RequestedLeaveEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LeaveEventPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final ApplicationProperties properties;

    public void publishRequestedEvent(RequestedLeaveEvent event) {
        this.send(properties.requestedLeavesRoutingKey(), event);
    }

    public void publishApprovedEvent(ApprovedLeaveEvent event) {
        this.send(properties.approvedLeavesRoutingKey(), event);
    }

    public void publishRejectedEvent(RejectedLeaveEvent event) {
        this.send(properties.rejectedLeavesRoutingKey(), event);
    }

    public void publishCancelledEvent(CancelledLeaveEvent event) {
        this.send(properties.cancelledLeavesRoutingKey(), event);
    }

    private void send(String routingKey, Object payload) {
        rabbitTemplate.convertAndSend(properties.leaveEventsExchange(), routingKey, payload);
    }
}
