package com.paccy.account.utils;

import com.paccy.account.entities.AccountType;

public record CreateAccountRequest(
        Integer customerId,
        Double balance,
        String currency,
        AccountType accountType
) {
}
