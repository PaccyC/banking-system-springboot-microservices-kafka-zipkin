package com.paccy.customer_account.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerClient {
    @Value("http://localhost:8050/api/v1/customer")
    private String customerUrl;

    private  final RestTemplate restTemplate;

    public CustomerResponse getCurrentCustomer(String token) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + token);
        ParameterizedTypeReference<CustomerResponse> responseType = new ParameterizedTypeReference<>() {};

        ResponseEntity<CustomerResponse> responseEntity = restTemplate.exchange(
                customerUrl+"/me",
                HttpMethod.GET,
                new HttpEntity<>(headers),
                responseType
        );
        if (responseEntity.getStatusCode().isError()){
            throw  new Exception("Error while processing product purchase request :: "+ responseEntity.getStatusCode());
        }
     return  responseEntity.getBody();
    }
}
