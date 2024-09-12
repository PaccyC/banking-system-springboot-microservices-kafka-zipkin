package com.paccy.customer_account.controllers;

import com.paccy.customer_account.entities.Account;
import com.paccy.customer_account.services.AccountService;
import com.paccy.customer_account.utils.CreateAccountRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(
            @RequestBody CreateAccountRequest createAccountRequest,
            @RequestHeader("Authorization") String token
    ){
        return  ResponseEntity.ok(accountService.createAccountForCurrentCustomer(createAccountRequest,token));
    }
}
