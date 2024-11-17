package com.paccy.banking_system.customer.controllers;

import com.paccy.banking_system.customer.auth.services.JwtService;
import com.paccy.banking_system.customer.entities.Customer;
import com.paccy.banking_system.customer.entities.domain.ApiResponse;
import com.paccy.banking_system.customer.services.CustomerService;
import com.paccy.banking_system.customer.utils.EditCustomerRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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
    public ResponseEntity<ApiResponse<Optional<Customer>>> getCurrentCustomer() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    System.out.println("IsAuthenticated:" +authentication.isAuthenticated());
    System.out.println(authentication);
        if (authentication != null && authentication.isAuthenticated()
                && !(authentication.getPrincipal() instanceof String)) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            Optional<Customer> customer= customerService.getCustomerByEmail(userDetails.getUsername());

            return new ApiResponse<>(customer,"Current customer retrieved successfully",HttpStatus.OK).toResponseEntity();
        } else {
            log.warn("No authenticated user found");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Customer>> getCustomerById(
            @PathVariable Integer id
    ){
     Customer response= customerService.getCustomerById(id);
        return new ApiResponse<>(response,"Customer Profile retrieved Successfully",HttpStatus.OK).toResponseEntity();
    }



    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Customer>> editCustomer(
            @RequestBody @Validated EditCustomerRequest editCustomerRequest,
            @PathVariable Integer id
    ){
     Customer  response= customerService.editCustomer(editCustomerRequest,id);
        return new ApiResponse<>(response,"Customer Profile updated successfully",HttpStatus.OK).toResponseEntity();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteCustomer(
            @PathVariable Integer id
    ){
        return new ApiResponse<>("Successfully deleted","Customer Profile deleted successfully",HttpStatus.OK).toResponseEntity();
    }

}
