package com.paccy.banking_system.transaction.kafka;

import com.paccy.banking_system.transaction.enums.Status;

public record TransactionSuccessMessage(
        String transactionId,
        Integer toAccountId,
        Double amount,
        Status status
) {
}
