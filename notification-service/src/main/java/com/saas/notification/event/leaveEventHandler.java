package com.saas.notification.event;

import com.saas.notification.dto.RequestedLeaveEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class leaveEventHandler {

    @RabbitListener(queues = "${notifications.requested-leaves-queue}")
    public void handleRequestedLeaveEvent(RequestedLeaveEvent event) {
        log.info("Received requested leave event: {}", event);
    }
}
