package com.paccy.transaction.kafka;

import com.paccy.transaction.enums.Status;


public record TransactionConfirmation(
        String transactionId,
        Integer toAccountId,
        Double amount,
        Status status

) {
}
