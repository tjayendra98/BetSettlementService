package com.betsettlement.rocketmq;

import com.betsettlement.dto.BetSettlement;

public interface BetSettlementsProducerMock {
    void sendSettlement(BetSettlement dto);
}
