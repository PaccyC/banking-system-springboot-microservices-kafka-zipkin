package com.paccy.banking_system.customer.services;

import com.paccy.banking_system.customer.entities.Customer;
import com.paccy.banking_system.customer.utils.EditCustomerRequest;
import com.paccy.banking_system.customer.exceptions.CustomerNotFoundException;
import com.paccy.banking_system.customer.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public interface CustomerService {

    public Customer getCustomerById(UUID id);

    public Customer editCustomer(EditCustomerRequest editCustomerRequest, UUID id);

    public String deleteCustomer(UUID id);


    public Optional<Customer> getCustomerByEmail(String email);
}