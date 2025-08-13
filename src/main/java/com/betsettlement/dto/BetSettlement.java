package com.betsettlement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BetSettlement {

    private Long betId;
    private String userId;
    private String eventId;
    private String eventWinnerId;
    private Integer betAmount;
}
