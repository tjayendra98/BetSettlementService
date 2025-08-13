package com.betsettlement.controller;

import com.betsettlement.dto.EventOutcome;
import com.betsettlement.kafka.EventOutcomeProducer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class EventOutcomeController {

    private final EventOutcomeProducer eventOutcomeProducer;

    @PostMapping("/event/publish")
    public ResponseEntity<String> publishEventOutcome(@RequestBody EventOutcome outcome) {
        if(ObjectUtils.isEmpty(outcome)) {
            return ResponseEntity.badRequest().body("Event outcome should not be empty.");
        }
        eventOutcomeProducer.sendEventOutcome(outcome);
        return ResponseEntity.accepted().body("Outcome published to Kafka");
    }

}
