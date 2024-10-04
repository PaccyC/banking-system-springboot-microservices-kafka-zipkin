package com.paccy.banking_system.transaction.kafka;

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
    private final KafkaTemplate<String, TransactionSuccessMessage> kafkaTemplate;

    public void sendTransactionConfirmation(TransactionSuccessMessage transactionSuccessMessage) {

        log.info("Sending transaction confirmation ...");

        Message<TransactionSuccessMessage> message= MessageBuilder
                .withPayload(transactionSuccessMessage)
                .setHeader(KafkaHeaders.TOPIC,"transaction-topic")
                .build();

        kafkaTemplate.send(message);


    }
}
