package com.paccy.transaction.account;

import com.paccy.transaction.utils.AccountResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@FeignClient(value = "customer-account", url = "http://localhost:8060/api/v1/account")
public interface AccountClient {

    @GetMapping("/{id}")
    AccountResponse getAccountById(@PathVariable("id") Integer accountId);


    @PutMapping("/update-balance/{id}")
    void updateBalance(@PathVariable("id") Integer accountId,
                       @RequestParam("newBalance") Double newBalance,
                       @RequestHeader("Authorization") String token

                       );

}
