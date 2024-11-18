package com.paccy.banking_system.customer.services.impl;

import com.paccy.banking_system.customer.entities.Customer;
import com.paccy.banking_system.customer.exceptions.CustomerNotFoundException;
import com.paccy.banking_system.customer.repositories.CustomerRepository;
import com.paccy.banking_system.customer.services.CustomerService;
import com.paccy.banking_system.customer.utils.EditCustomerRequest;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class CustomerServiceImpl  implements CustomerService {
    private final CustomerRepository customerRepository;


    /**
     *Returns the customer with the provided id
     **/

    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).orElseThrow(
                ()-> new CustomerNotFoundException("Customer with id " + id + " not found")
        );
    }

    /**
     * Updates the details of the customer if the customer exists
     *
     **/
    public Customer editCustomer(EditCustomerRequest editCustomerRequest, Integer id) {

        Customer customer = getCustomerById(id);
        customer.setFirstName(editCustomerRequest.firstName());
        customer.setLastName(editCustomerRequest.lastName());
        customer.setEmail(editCustomerRequest.email());

        return  customerRepository.save(customer);
    }

    /**
     * Deletes the customer with the ID in the path
     **/
    public String deleteCustomer(Integer id) {
        Customer customer = getCustomerById(id);
        customerRepository.delete(customer);
        return "Customer with id " + id + " deleted";
    }


    /**
     * Retrieves the details of the customer based on the email specified or email in the request
     **/

    public Optional<Customer> getCustomerByEmail(String email) {
        return Optional.ofNullable(customerRepository.findByEmail(email)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with email " + email + " not found")));
    }
}
