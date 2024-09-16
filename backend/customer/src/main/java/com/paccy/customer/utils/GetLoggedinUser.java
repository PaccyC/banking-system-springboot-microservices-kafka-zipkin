package com.paccy.customer.utils;

import com.paccy.customer.CustomerResponse;
import com.paccy.customer.entities.Customer;
import com.paccy.customer.exceptions.JwtExpiredException;
import com.paccy.customer.exceptions.UnAuthenticatedException;
import com.paccy.customer.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetLoggedinUser {
    private final CustomerRepository customerRepository;

    public CustomerResponse getLoggedinUser() throws Exception {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(principal);

        // Check if the user is anonymous
        if (principal.equals("anonymousUser")) {
            throw new UnAuthenticatedException("You are not logged in!");
        }

        String email;
        if (principal instanceof UserDetails) {
            email = ((UserDetails) principal).getUsername();
        } else {
            email = principal.toString();
        }

        // Fetch customer by email
        Optional<Customer> customerOpt = customerRepository.findByEmail(email);


        if (!customerOpt.isPresent()) {
            throw new ChangeSetPersister.NotFoundException();
        }


        Customer customer = customerOpt.get();
        CustomerResponse customerResponse = new CustomerResponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhoneNumber()
        );

        return customerResponse;
    }
}
