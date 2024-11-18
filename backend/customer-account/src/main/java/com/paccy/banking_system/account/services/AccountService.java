package com.paccy.banking_system.account.services;

import com.paccy.banking_system.account.customer.CustomerClient;
import com.paccy.banking_system.account.customer.CustomerResponse;
import com.paccy.banking_system.account.entities.Account;
import com.paccy.banking_system.account.entities.domains.ApiResponse;
import com.paccy.banking_system.account.exceptions.AccountNotFoundException;
import com.paccy.banking_system.account.exceptions.NotAuthorizedException;
import com.paccy.banking_system.account.repository.AccountRepository;
import com.paccy.banking_system.account.utils.CreateAccountRequest;
import com.paccy.banking_system.account.utils.UpdateAccountRequest;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public interface AccountService {


    public Account createAccountForCurrentCustomer(CreateAccountRequest createAccountRequest, String token) ;

    public Account getCustomerAccountById(Integer accountId);

    public List<Account> getAllAccountOfCustomer( String token);

    public Account updateAccount(Integer accountId, UpdateAccountRequest updateAccountRequest, String token);

    public String deleteAccount(Integer accountId,String token);

    public void updateBalance(Integer accountId, Double newBalance,String token);
}
