package com.paccy.banking_system.transaction.account;

import com.paccy.banking_system.transaction.entities.domain.ApiResponse;
import com.paccy.banking_system.transaction.utils.AccountResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        name = "customer-account",
        url = "http://localhost:8866/api/v1/account")
public interface AccountClient {

    @GetMapping("/{id}")
    ApiResponse<AccountResponse> getAccountById(@PathVariable("id") Integer accountId);


    @PutMapping("/update-balance/{id}")
    void updateBalance(@PathVariable("id") Integer accountId,
                       @RequestParam("newBalance") Double newBalance,
                       @RequestHeader("Authorization") String token

                       );
}
