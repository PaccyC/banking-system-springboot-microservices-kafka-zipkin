package com.paccy.customer_account.services;

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


    @Value("http://localhost:8050/api/v1/customer/{id}")
    private String customerUrl;

    private  final RestTemplate restTemplate;

    @Value("bbb2JvLuOKbhGcbf3iw3RP3Y1leWUouWU6mxAMZk0hmQ=wiwwjewj3e82u812q281wdpqu23usg")
    private String secretKey;


    private Integer extractCustomerIdFromToken(String token) {
        Claims claims= Jwts
                .parser()
                .setSigningKey(getSecretKey())
                .build()
                .parseClaimsJws(token.replace("Bearer ", "")).getBody();

    return claims.get("CustomerId", Integer.class);
    }
    private SecretKey getSecretKey() {
        byte[] keyBytes= Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    public Account createAccountForCurrentCustomer(CreateAccountRequest createAccountRequest, String token) {
        Integer customerId = extractCustomerIdFromToken(token);

        Account account = Account
                .builder()
                .accountType(createAccountRequest.accountType())
                .currency(createAccountRequest.currency())
                .balance(createAccountRequest.balance())
                .createDate(LocalDate.now())
                .updateDate(LocalDate.now())
                .customerId(customerId)
                .build();

        return accountRepository.save(account);
    }
}
