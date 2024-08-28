package com.paccy.customer.services;

import com.paccy.customer.entities.Customer;
import com.paccy.customer.exceptions.CustomerNotFoundException;
import com.paccy.customer.repositories.CustomerRepository;
import com.paccy.customer.utils.EditCustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}