package com.paccy.banking_system.account.controllers;

import com.paccy.banking_system.account.entities.Account;
import com.paccy.banking_system.account.entities.domains.ApiResponse;
import com.paccy.banking_system.account.utils.CreateAccountRequest;
import com.paccy.banking_system.account.utils.UpdateAccountRequest;
import com.paccy.banking_system.account.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Account>> createAccount(
            @RequestBody CreateAccountRequest createAccountRequest,
            @RequestHeader("Authorization") String token){
        Account response= accountService.createAccountForCurrentCustomer(createAccountRequest,token);
        return  new  ApiResponse<>(response,"Account Created successfully", HttpStatus.CREATED).toResponseEntity();
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

    @PutMapping("/update-balance/{id}")
    public ResponseEntity<Void> updateAccountBalance(
            @PathVariable("id") Integer accountId,
            @RequestParam Double newBalance,
            @RequestHeader("Authorization") String token
    ){

        accountService.updateBalance(accountId,newBalance,token);
        return ResponseEntity.ok().build();
    }
}
