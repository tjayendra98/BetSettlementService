package com.betsettlement.service.impl;

import com.betsettlement.dto.BetSettlement;
import com.betsettlement.dto.EventOutcome;
import com.betsettlement.entity.Bet;
import com.betsettlement.rocketmq.impl.BetSettlementsProducerMockImpl;
import com.betsettlement.service.BetService;
import com.betsettlement.service.BetSettlementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class BetSettlementServiceImpl implements BetSettlementService {

    private final BetService betService;
    private final BetSettlementsProducerMockImpl betSettlementsProducer;

    @Override
    public void processBetSettlement(EventOutcome eventOutcome) {
        List<Bet> bets = betService.getBetsByEventId(eventOutcome.getEventId());
        if (CollectionUtils.isEmpty(bets)) {
            log.warn("No bets found to settle.");
            return;
        }

        bets.stream().filter(bet -> bet.getEventWinnerId().equals(eventOutcome.getEventWinnerId()))
                .map(bet -> new BetSettlement(bet.getBetId(), bet.getUserId(), bet.getEventId(),
                        bet.getEventWinnerId(), bet.getBetAmount()))
                .forEach(betSettlementsProducer::sendSettlement);

    }
}
