package com.betsettlement.service;

import com.betsettlement.dto.EventOutcome;
import com.betsettlement.entity.Bet;

import java.util.List;

public interface BetSettlementService {

     void processBetSettlement( EventOutcome eventOutcome);
}
