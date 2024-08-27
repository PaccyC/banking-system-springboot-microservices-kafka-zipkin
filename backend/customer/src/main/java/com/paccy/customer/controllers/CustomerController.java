package com.paccy.customer.controllers;

import com.paccy.customer.entities.Customer;
import com.paccy.customer.services.CustomerService;
import com.paccy.customer.utils.CustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;


    @PostMapping
    private ResponseEntity<Customer> registerCustomer(
            @RequestBody CustomerRequest customerRequest
    ) {

        return  ResponseEntity.ok(customerService.registerCustomer(customerRequest));
    }

}
