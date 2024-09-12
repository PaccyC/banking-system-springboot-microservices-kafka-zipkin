package com.paccy.customer.controllers;

import com.paccy.customer.auth.services.JwtService;
import com.paccy.customer.entities.Customer;
import com.paccy.customer.repositories.CustomerRepository;
import com.paccy.customer.services.CustomerService;
import com.paccy.customer.utils.EditCustomerRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor

@RequestMapping("/api/v1/customer")
public class CustomerController {
    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerService customerService;
    private final JwtService jwtService;
 ;

//
//    @GetMapping("")
//    public ResponseEntity<Optional<Customer>> getCurrentCustomer() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null && authentication.isAuthenticated() ) {
//            System.out.println(authentication.getPrincipal());
//        } else {
//            log.warn("No authenticated user found");
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//        return null;
//    }

    @GetMapping("")
    public ResponseEntity<Optional<Customer>> getCustomerProfile(
            @RequestHeader("Authorization") String authHeader){
        String token=authHeader.substring(7);
        String email=jwtService.extractUsername(token);
        log.info("Extracted email:"+ email);

        Optional<Customer> customer= customerService.getCustomerByEmail(email);
        if (customer.isPresent()){
            return ResponseEntity.ok(customer);

        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }


    }

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
