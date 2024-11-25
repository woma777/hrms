package com.saas.leave.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.saas.leave.dto.event.ApprovedLeaveEvent;
import com.saas.leave.dto.event.CancelledLeaveEvent;
import com.saas.leave.dto.event.RejectedLeaveEvent;
import com.saas.leave.dto.event.RequestedLeaveEvent;
import com.saas.leave.enums.LeaveEventType;
import com.saas.leave.model.LeaveEvent;
import com.saas.leave.rabbitmq.LeaveEventPublisher;
import com.saas.leave.repository.LeaveEventRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LeaveEventService {

    private final LeaveEventRepository leaveEventRepository;
    private final ObjectMapper objectMapper;
    private final LeaveEventPublisher leaveEventPublisher;

    public void createRequestedEvent(RequestedLeaveEvent event) {

        LeaveEvent leaveEvent = new LeaveEvent();
        leaveEvent.setEventType(LeaveEventType.LEAVE_REQUESTED);
        leaveEvent.setPayload(toJsonPayload(event));
        log.info("Requested leave event: {}", event);
        leaveEventRepository.save(leaveEvent);
    }

    public void createApprovedEvent(ApprovedLeaveEvent event) {

        LeaveEvent leaveEvent = new LeaveEvent();
        leaveEvent.setEventType(LeaveEventType.LEAVE_APPROVED);
        leaveEvent.setPayload(toJsonPayload(event));
        log.info("Approved leave event: {}", event);
        leaveEventRepository.save(leaveEvent);
    }

    public void createRejectedEvent(RejectedLeaveEvent event) {

        LeaveEvent leaveEvent = new LeaveEvent();
        leaveEvent.setEventType(LeaveEventType.LEAVE_REJECTED);
        leaveEvent.setPayload(toJsonPayload(event));
        log.info("Rejected leave event: {}", event);
        leaveEventRepository.save(leaveEvent);
    }

    public void createCancelledEvent(CancelledLeaveEvent event) {

        LeaveEvent leaveEvent = new LeaveEvent();
        leaveEvent.setEventType(LeaveEventType.LEAVE_CANCELLED);
        leaveEvent.setPayload(toJsonPayload(event));
        log.info("Cancelled leave event: {}", event);
        leaveEventRepository.save(leaveEvent);
    }

    public void publishLeaveEvents() {
        Sort sort = Sort.by("createdAt").ascending();
        List<LeaveEvent> events = leaveEventRepository.findAll(sort);
        log.info("Found {} leave events to be published", events.size());
        for (LeaveEvent event : events) {
            this.publishEvent(event);
            leaveEventRepository.delete(event);
        }
    }

    private void publishEvent(LeaveEvent leaveEvent) {
        LeaveEventType eventType = leaveEvent.getEventType();
        switch (eventType) {
            case LEAVE_REQUESTED:
                RequestedLeaveEvent requestedEvent =
                        fromJsonPayload(leaveEvent.getPayload(), RequestedLeaveEvent.class);
                log.info("Publishing requested leave event: {}", requestedEvent);
                leaveEventPublisher.publishRequestedEvent(requestedEvent);
                break;
            case LEAVE_APPROVED:
                ApprovedLeaveEvent approvedEvent = fromJsonPayload(leaveEvent.getPayload(), ApprovedLeaveEvent.class);
                log.info("Publishing approved leave event: {}", approvedEvent);
                leaveEventPublisher.publishApprovedEvent(approvedEvent);
                break;
            case LEAVE_REJECTED:
                RejectedLeaveEvent rejectedEvent = fromJsonPayload(leaveEvent.getPayload(), RejectedLeaveEvent.class);
                log.info("Publishing rejected leave event: {}", rejectedEvent);
                leaveEventPublisher.publishRejectedEvent(rejectedEvent);
                break;
            case LEAVE_CANCELLED:
                CancelledLeaveEvent cancelledEvent =
                        fromJsonPayload(leaveEvent.getPayload(), CancelledLeaveEvent.class);
                log.info("Publishing cancelled leave event: {}", cancelledEvent);
                leaveEventPublisher.publishCancelledEvent(cancelledEvent);
                break;
            default:
                log.warn("Unsupported event type: {}", eventType);
        }
    }

    private String toJsonPayload(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private <T> T fromJsonPayload(String json, Class<T> type) {
        try {
            return objectMapper.readValue(json, type);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
