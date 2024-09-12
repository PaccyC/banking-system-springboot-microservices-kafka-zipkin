package com.paccy.customer_account.utils;

import com.paccy.customer_account.entities.AccountType;

public record CreateAccountRequest(
        Integer customerId,
        Double balance,
        String currency,
        AccountType accountType
) {
}
