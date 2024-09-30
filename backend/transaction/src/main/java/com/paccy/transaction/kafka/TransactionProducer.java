package com.paccy.transaction.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionProducer {
    private final KafkaTemplate<String,TransactionConfirmation> kafkaTemplate;

    public void sendTransactionConfirmation(String topic, TransactionConfirmation transactionConfirmation) {

        log.info("Sending transaction confirmation ...");

        Message<TransactionConfirmation> message= MessageBuilder
                .withPayload(transactionConfirmation)
                .setHeader(KafkaHeaders.TOPIC,"transaction-topic")
                .build();


        kafkaTemplate.send(message);


    }
}
