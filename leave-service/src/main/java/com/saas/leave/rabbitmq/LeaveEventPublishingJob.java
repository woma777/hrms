package com.saas.leave.rabbitmq;

import com.saas.leave.service.LeaveEventService;
import java.time.Instant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.core.LockAssert;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class LeaveEventPublishingJob {

    private final LeaveEventService leaveEventService;

    @Scheduled(cron = "${leaves.publish-leave-events-job-cron}")
    @SchedulerLock(name = "publishLeaveEvents")
    public void publishLeaveEvents() {
        LockAssert.assertLocked();
        log.info("Publishing leave events at: {}", Instant.now());
        leaveEventService.publishLeaveEvents();
    }
}
