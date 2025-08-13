package com.betsettlement.rocketmq;

import com.betsettlement.dto.BetSettlement;

public interface BetSettlementsConsumerMock {

    void onMessage(BetSettlement betSettlement);
}
