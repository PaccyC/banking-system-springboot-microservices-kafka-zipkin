package com.paccy.customer.services;

import com.paccy.customer.entities.Address;
import com.paccy.customer.entities.Customer;
import com.paccy.customer.repositories.CustomerRepository;
import com.paccy.customer.utils.CustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer registerCustomer(CustomerRequest customerRequest) {

        var customer = Customer
                .builder()
                .id(customerRequest.id())
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .phoneNumber(customerRequest.phoneNumber())
                .address(Address
                        .builder()
                        .street(customerRequest.address().getStreet())
                        .houseNumber(customerRequest.address().getHouseNumber())
                        .street(customerRequest.address().getStreet())
                        .build())
                .build();
        return customerRepository.save(customer);
    }

}