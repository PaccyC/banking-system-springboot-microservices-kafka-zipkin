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
import org.springframework.security.core.userdetails.UserDetails;
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



@GetMapping("/current")
    public ResponseEntity<Optional<Customer>> getCurrentCustomer() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Checking if we get principal and current authentication status
//    System.out.println("Principal: "+ authentication.getPrincipal());
    System.out.println("IsAuthenticated:" +authentication.isAuthenticated());
    System.out.println(authentication);
        if (authentication != null && authentication.isAuthenticated()
                && !(authentication.getPrincipal() instanceof String)) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            return ResponseEntity.ok(customerService.getCustomerByEmail(userDetails.getUsername()));
        } else {
            log.warn("No authenticated user found");
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
