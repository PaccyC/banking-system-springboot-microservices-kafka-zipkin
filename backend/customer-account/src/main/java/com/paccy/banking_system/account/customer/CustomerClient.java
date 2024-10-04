package com.paccy.banking_system.account.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "customer-service", url = "http://localhost:8050/api/v1/customer")
public interface CustomerClient{

    @GetMapping("/current")
    CustomerResponse getCurrentCustomer(@RequestHeader("Authorization") String token);

}
