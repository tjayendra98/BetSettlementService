package com.betsettlement.kafka;

import com.betsettlement.dto.EventOutcome;
import com.betsettlement.service.BetSettlementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventOutcomeConsumer {

    private final BetSettlementService betSettlementService;

    @KafkaListener(topics = "${kafka.topic}", groupId = "${kafka.consumer.group-id}")
    public void consumeEventOutcome(EventOutcome eventOutcome, Acknowledgment acknowledgment) {
        if (Objects.nonNull(eventOutcome)) {
            log.info("KAFKA-CONSUMER: Event-outcome consumed with EventId: {}", eventOutcome.getEventId());
            betSettlementService.processBetSettlement(eventOutcome);
        } else {
            log.warn("Consumed event-outcome is null.");
        }
        acknowledgment.acknowledge();
    }
}
