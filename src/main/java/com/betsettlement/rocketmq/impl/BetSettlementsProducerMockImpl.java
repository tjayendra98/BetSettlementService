package com.betsettlement.rocketmq.impl;

import com.betsettlement.dto.BetSettlement;
import com.betsettlement.rocketmq.BetSettlementsConsumerMock;
import com.betsettlement.rocketmq.BetSettlementsProducerMock;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class BetSettlementsProducerMockImpl implements BetSettlementsProducerMock {

    @Value("${rocketmq.mock.topic}")
    private String topic;

    private final BetSettlementsConsumerMock betSettlementsConsumerMock;

    @Override
    public void sendSettlement(BetSettlement betSettlement) {
        log.info("ROCKETMQ MOCK PRODUCER: Sending settlement data : {} on RocketMQ topic: {}", betSettlement.toString(), topic);
        /**
         *
         * Send message on RocketMQ Producer
         * rocketMQTemplate.convertAndSend(topic, dto);
         * Below is a direct consumer function call to stimulate the ROCKETMQ Consumer
         *
         **/
        betSettlementsConsumerMock.onMessage(betSettlement);
    }
}
