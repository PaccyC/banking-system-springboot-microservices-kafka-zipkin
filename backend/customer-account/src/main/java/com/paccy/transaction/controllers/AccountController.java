package com.paccy.transaction.controllers;

import com.paccy.transaction.entities.Account;
import com.paccy.transaction.services.AccountService;
import com.paccy.transaction.utils.CreateAccountRequest;
import com.paccy.transaction.utils.UpdateAccountRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public  ResponseEntity<Account> getAccountById(
            @PathVariable("id") Integer accountId
    ){
        return ResponseEntity.ok(accountService.getCustomerAccountById(accountId));
    }
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts(
            @RequestHeader("Authorization") String token
    ){
        return  ResponseEntity.ok(accountService.getAllAccountOfCustomer(token));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(
            @PathVariable("id") Integer accountId,
            @RequestHeader("Authorization") String token,
            @RequestBody UpdateAccountRequest updateAccountRequest
    ){
        return ResponseEntity.ok(accountService.updateAccount(accountId,updateAccountRequest,token));
    }

    public ResponseEntity<String> deleteAccount(
            @PathVariable("id") Integer accountId,
            @RequestHeader("Authorization") String token

            ){
        return ResponseEntity.ok(accountService.deleteAccount(accountId,token));
    }
}
