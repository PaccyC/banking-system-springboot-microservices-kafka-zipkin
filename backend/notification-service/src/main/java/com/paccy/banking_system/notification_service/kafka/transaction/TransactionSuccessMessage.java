package com.paccy.banking_system.notification_service.kafka.transaction;

public record TransactionSuccessMessage(
        String transactionId,
        Integer toAccountId,
        Double amount,
        Status status
) {
}
