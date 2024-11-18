package com.paccy.banking_system.account.services.impl;

import com.paccy.banking_system.account.customer.CustomerClient;
import com.paccy.banking_system.account.customer.CustomerResponse;
import com.paccy.banking_system.account.entities.Account;
import com.paccy.banking_system.account.entities.domains.ApiResponse;
import com.paccy.banking_system.account.exceptions.AccountNotFoundException;
import com.paccy.banking_system.account.exceptions.NotAuthorizedException;
import com.paccy.banking_system.account.repository.AccountRepository;
import com.paccy.banking_system.account.services.AccountService;
import com.paccy.banking_system.account.utils.CreateAccountRequest;
import com.paccy.banking_system.account.utils.UpdateAccountRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CustomerClient customerClient;


    /**
     * It creates the account for the currently logged-in user
     * Current user is got from the token parameter passed
     * Account details like balance, types,etc... are provided in the request also
     **/

    public Account createAccountForCurrentCustomer(CreateAccountRequest createAccountRequest, String token) {

        ApiResponse<CustomerResponse> customer= customerClient.getCurrentCustomer(token);
        log.info("Customer:{}",customer);
        Account account = Account
                .builder()
                .accountType(createAccountRequest.accountType())
                .currency(createAccountRequest.currency())
                .balance(createAccountRequest.balance())
                .createDate(LocalDate.now())
                .updateDate(LocalDate.now())
                .customerId(customer.getData().getId())
                .build();

        return accountRepository.save(account);
    }

    /**
     * Retrieves the details of the account
     * If the account doesn't exist , it throws error
     */

    public Account getCustomerAccountById(Integer accountId) {
        return accountRepository.findById(accountId).orElseThrow(
                ()-> new AccountNotFoundException("Sorry, the account does not exist. Please create a new account.")
        );
    }

    /**
     * It retrieves all accounts that authenticated customer is associated with
     */
    public List<Account> getAllAccountOfCustomer(String token) {

        try {
            ApiResponse<CustomerResponse> customer= customerClient.getCurrentCustomer(token);
            return accountRepository.findAllByCustomerId(customer.getData().getId());

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

    /**
     * It updates the details of the account retrieved by ID like currency
     * It will throw an error if account is not found or someone is trying to edit account
     * which is not him/her
     */
    public Account updateAccount(Integer accountId, UpdateAccountRequest updateAccountRequest, String token) {
        ApiResponse<CustomerResponse> customer= customerClient.getCurrentCustomer(token);


        var account= accountRepository.findById(accountId).orElseThrow(
                ()-> new AccountNotFoundException("Sorry, the account does not exist. Please create a new account.")
        );
        if (!Objects.equals(customer.getData().getId(), account.getCustomerId())){
            throw  new NotAuthorizedException("Not allowed to edit this account!");
        }

        account.setCurrency(updateAccountRequest.currency());
        account.setUpdateDate(LocalDate.now());

        return accountRepository.save(account);

    }

    /**
     * It removes the account
     */
    public String deleteAccount(Integer accountId,String token) {
        ApiResponse<CustomerResponse> customer= customerClient.getCurrentCustomer(token);
//Check if the current user, is the owner of the account
        var account= accountRepository.findById(accountId).orElseThrow(
                ()-> new AccountNotFoundException("Sorry, the account does not exist. Please create a new account.")
        );
        if (!Objects.equals(customer.getData().getId(), account.getCustomerId())){
            throw  new NotAuthorizedException("Not allowed to edit this account!");
        }


        accountRepository.deleteById(accountId);
        return  "Account deleted successfully";
    }

    /**
     * It updates the balance of the account
     * The parameters required are accountId, newBalance and token to make sure that user is authenticated and authorized
     */
    public void updateBalance(Integer accountId, Double newBalance,String token) {
        ApiResponse<CustomerResponse> customer= customerClient.getCurrentCustomer(token);
        var account= accountRepository.findById(accountId).orElseThrow(
                ()-> new AccountNotFoundException("Sorry, the account does not exist. Please create a new account.")
        );
        if (!Objects.equals(customer.getData().getId(), account.getCustomerId())){
            throw  new NotAuthorizedException("Sorry! It seems like the account you are trying to edit is not yours");
        }
        account.setBalance(newBalance);
        accountRepository.save(account);
    }
}
