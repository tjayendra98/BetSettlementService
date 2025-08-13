package com.betsettlement.rocketmq.impl;

import com.betsettlement.dto.BetSettlement;
import com.betsettlement.rocketmq.BetSettlementsConsumerMock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
public class BetSettlementsConsumerMockImpl implements BetSettlementsConsumerMock {


    @Override
    public void onMessage(BetSettlement betSettlement) {

        if (Objects.isNull(betSettlement)) {
            log.warn("Consumed bet-settlement is null.");
            return;
        }

        log.info("ROCKETMQ MOCK CONSUMER: Consumed bet-settlement for betId: {} and eventId: {}", betSettlement.getBetId(), betSettlement.getEventId());

        /**
         *
         *  Perform functionality to settle bets like:
         *
         *  Calling Payment Service to make payment
         *  Update Bet Settlement status from PENDING to DONE
         *
         */

    }
}
