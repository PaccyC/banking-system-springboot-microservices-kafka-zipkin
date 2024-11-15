package com.paccy.banking_system.transaction.account;

import com.paccy.banking_system.transaction.utils.AccountResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "customer-account", url = "customer-account")
public interface AccountClient {

    @GetMapping("/{id}")
    AccountResponse getAccountById(@PathVariable("id") Integer accountId);


    @PutMapping("/update-balance/{id}")
    void updateBalance(@PathVariable("id") Integer accountId,
                       @RequestParam("newBalance") Double newBalance,
                       @RequestHeader("Authorization") String token

                       );

}
