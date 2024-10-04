package com.paccy.banking_system.transaction.utils;

import java.math.BigDecimal;

public record AccountResponse(
        Integer id,
        String currency,
        Double balance
) {

}
