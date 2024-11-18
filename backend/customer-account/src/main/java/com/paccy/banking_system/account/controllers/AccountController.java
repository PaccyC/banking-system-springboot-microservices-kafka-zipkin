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
    public  ResponseEntity<ApiResponse<Account>> getAccountById(
            @PathVariable("id") Integer accountId
    ){
        Account response= accountService.getCustomerAccountById(accountId);
        return new ApiResponse<>(response,"Account retrieved successfully", HttpStatus.OK).toResponseEntity();
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<Account>>> getAllAccounts(
            @RequestHeader("Authorization") String token
    ){
        List<Account> response= accountService.getAllAccountOfCustomer(token);
        return  new  ApiResponse<>(response,"Accounts retrieved successfully", HttpStatus.OK).toResponseEntity();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Account>> updateAccount(
            @PathVariable("id") Integer accountId,
            @RequestHeader("Authorization") String token,
            @RequestBody UpdateAccountRequest updateAccountRequest
    ){


        Account response= accountService.updateAccount(accountId,updateAccountRequest,token);
        return new  ApiResponse<>(response,"Account updated successfully", HttpStatus.OK).toResponseEntity();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteAccount(
            @PathVariable("id") Integer accountId,
            @RequestHeader("Authorization") String token

            ){
        String response= accountService.deleteAccount(accountId,token);
        return  new  ApiResponse<>(response,"Account removed successfully",HttpStatus.NO_CONTENT).toResponseEntity();
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
