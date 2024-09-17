package com.paccy.transaction.utils;

import com.paccy.transaction.entities.AccountType;

public record CreateAccountRequest(
        Integer customerId,
        Double balance,
        String currency,
        AccountType accountType
) {
}
