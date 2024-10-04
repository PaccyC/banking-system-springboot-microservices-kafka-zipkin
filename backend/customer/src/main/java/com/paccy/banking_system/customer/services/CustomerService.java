package com.paccy.banking_system.customer.services;

import com.paccy.banking_system.customer.entities.Customer;
import com.paccy.banking_system.customer.utils.EditCustomerRequest;
import com.paccy.banking_system.customer.exceptions.CustomerNotFoundException;
import com.paccy.banking_system.customer.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;


    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).orElseThrow(
                ()-> new CustomerNotFoundException("Customer with id " + id + " not found")
        );
    }

    public Customer editCustomer(EditCustomerRequest editCustomerRequest, Integer id) {

        Customer customer = getCustomerById(id);
        customer.setFirstName(editCustomerRequest.firstName());
        customer.setLastName(editCustomerRequest.lastName());
        customer.setEmail(editCustomerRequest.email());

        return  customerRepository.save(customer);
    }

    public String deleteCustomer(Integer id) {
        Customer customer = getCustomerById(id);
        customerRepository.delete(customer);
        return "Customer with id " + id + " deleted";
    }


    public Optional<Customer> getCustomerByEmail(String email) {
        return Optional.ofNullable(customerRepository.findByEmail(email)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with email " + email + " not found")));
    }
}