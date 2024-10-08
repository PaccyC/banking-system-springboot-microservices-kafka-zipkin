package com.paccy.banking_system.account.services;

import com.paccy.banking_system.account.customer.CustomerClient;
import com.paccy.banking_system.account.customer.CustomerResponse;
import com.paccy.banking_system.account.entities.Account;
import com.paccy.banking_system.account.exceptions.AccountNotFoundException;
import com.paccy.banking_system.account.exceptions.NotAuthorizedException;
import com.paccy.banking_system.account.repository.AccountRepository;
import com.paccy.banking_system.account.utils.CreateAccountRequest;
import com.paccy.banking_system.account.utils.UpdateAccountRequest;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerClient customerClient;



    public Account createAccountForCurrentCustomer(CreateAccountRequest createAccountRequest, String token) {

                CustomerResponse customer= customerClient.getCurrentCustomer(token);
        Account account = Account
                .builder()
                .accountType(createAccountRequest.accountType())
                .currency(createAccountRequest.currency())
                .balance(createAccountRequest.balance())
                .createDate(LocalDate.now())
                .updateDate(LocalDate.now())
                .customerId(customer.getId())
                .build();

        return accountRepository.save(account);
    }

    public Account getCustomerAccountById(Integer accountId) {
        return accountRepository.findById(accountId).orElseThrow(
                ()-> new AccountNotFoundException("Sorry, the account does not exist. Please create a new account.")
        );
    }

    public List<Account> getAllAccountOfCustomer( String token) {

        try {
            CustomerResponse customer= customerClient.getCurrentCustomer(token);
            var accounts = accountRepository.findAllByCustomerId(customer.getId());
            return accounts;

        }
        catch (Exception e) {
            e.printStackTrace();
        }
      return  null;
    }

    public Account updateAccount(Integer accountId, UpdateAccountRequest updateAccountRequest, String token) {
        CustomerResponse customer= customerClient.getCurrentCustomer(token);


        var account= accountRepository.findById(accountId).orElseThrow(
                ()-> new AccountNotFoundException("Sorry, the account does not exist. Please create a new account.")
        );
        if (!Objects.equals(customer.getId(), account.getCustomerId())){
        throw  new NotAuthorizedException("Not allowed to edit this account!");
        }

        account.setCurrency(updateAccountRequest.currency());
        account.setUpdateDate(LocalDate.now());

        return accountRepository.save(account);

    }

    public String deleteAccount(Integer accountId,String token) {
        CustomerResponse customer= customerClient.getCurrentCustomer(token);
//Check if the current user, is the owner of the account
        var account= accountRepository.findById(accountId).orElseThrow(
                ()-> new AccountNotFoundException("Sorry, the account does not exist. Please create a new account.")
        );
        if (!Objects.equals(customer.getId(), account.getCustomerId())){
            throw  new NotAuthorizedException("Not allowed to edit this account!");
        }


        accountRepository.deleteById(accountId);
        return  "Account deleted successfully";
    }

    public void updateBalance(Integer accountId, Double newBalance,String token) {
        CustomerResponse customer= customerClient.getCurrentCustomer(token);
        var account= accountRepository.findById(accountId).orElseThrow(
                ()-> new AccountNotFoundException("Sorry, the account does not exist. Please create a new account.")
        );
        if (!Objects.equals(customer.getId(), account.getCustomerId())){
            throw  new NotAuthorizedException("Not allowed to edit this account!");
        }
        account.setBalance(newBalance);
        accountRepository.save(account);
    }
}
