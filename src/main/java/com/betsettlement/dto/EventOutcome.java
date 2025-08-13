package com.betsettlement.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EventOutcome {

    private String eventId;
    private String eventName;
    private String eventWinnerId;
}
