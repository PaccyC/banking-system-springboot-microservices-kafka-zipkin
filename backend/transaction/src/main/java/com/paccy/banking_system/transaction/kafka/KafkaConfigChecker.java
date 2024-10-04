package com.paccy.banking_system.transaction.kafka;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class KafkaConfigChecker {

    @Value("${spring.kafka.producer.bootstrap-servers}")
    private String bootstrapServers;

    @PostConstruct
    public void checkKafkaConfig() {
        System.out.println("Kafka Bootstrap Servers: " + bootstrapServers);
    }
}
