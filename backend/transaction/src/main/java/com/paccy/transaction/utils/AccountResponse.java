package com.paccy.transaction.utils;

import java.math.BigDecimal;

public record AccountResponse(
        Integer id,
        String currency,
        Double balance
) {
}
