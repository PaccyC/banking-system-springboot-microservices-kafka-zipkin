package com.paccy.banking_system.customer.services;

import com.paccy.banking_system.customer.entities.Customer;
import com.paccy.banking_system.customer.utils.EditCustomerRequest;
import com.paccy.banking_system.customer.exceptions.CustomerNotFoundException;
import com.paccy.banking_system.customer.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CustomerService {

    public Customer getCustomerById(Integer id);

    public Customer editCustomer(EditCustomerRequest editCustomerRequest, Integer id);

    public String deleteCustomer(Integer id);


    public Optional<Customer> getCustomerByEmail(String email);
}