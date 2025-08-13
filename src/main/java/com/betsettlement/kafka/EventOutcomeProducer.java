package com.betsettlement.kafka;

import com.betsettlement.dto.EventOutcome;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventOutcomeProducer {

    private final KafkaTemplate<String, EventOutcome> kafkaTemplate;

    @Value("${kafka.topic}")
    private String kafkaTopic;

    public void sendEventOutcome(EventOutcome dto) {
        kafkaTemplate.send(kafkaTopic, dto);
    }

}
