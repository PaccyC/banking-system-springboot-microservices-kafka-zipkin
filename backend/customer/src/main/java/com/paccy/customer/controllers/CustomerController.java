package com.paccy.customer.controllers;

import com.paccy.customer.entities.Customer;
import com.paccy.customer.services.CustomerService;
import com.paccy.customer.utils.EditCustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(
            @PathVariable Integer id
    ){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> editCustomer(
            @RequestBody @Validated EditCustomerRequest editCustomerRequest,
            @PathVariable Integer id
    ){
        return ResponseEntity.ok(customerService.editCustomer(editCustomerRequest,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(
            @PathVariable Integer id
    ){
        return ResponseEntity.ok(customerService.deleteCustomer(id));
    }

}
