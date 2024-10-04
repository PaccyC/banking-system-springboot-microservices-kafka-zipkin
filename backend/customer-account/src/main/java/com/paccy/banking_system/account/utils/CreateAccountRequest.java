package com.paccy.banking_system.account.utils;

import com.paccy.banking_system.account.entities.AccountType;

public record CreateAccountRequest(
        Integer customerId,
        Double balance,
        String currency,
        AccountType accountType
) {
}
