package com.paccy.customer_account.services;

import com.paccy.customer_account.customer.CustomerClient;
import com.paccy.customer_account.customer.CustomerResponse;
import com.paccy.customer_account.entities.Account;
import com.paccy.customer_account.repository.AccountRepository;
import com.paccy.customer_account.utils.CreateAccountRequest;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.crypto.SecretKey;
import java.time.LocalDate;

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
}
