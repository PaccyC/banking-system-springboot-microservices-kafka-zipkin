package com.paccy.banking_system.customer.services.impl;

import com.paccy.banking_system.customer.entities.Address;
import com.paccy.banking_system.customer.entities.Customer;
import com.paccy.banking_system.customer.entities.Role;
import com.paccy.banking_system.customer.exceptions.CustomerNotFoundException;
import com.paccy.banking_system.customer.repositories.CustomerRepository;
import com.paccy.banking_system.customer.utils.EditCustomerRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;
import  static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;


   public UUID customerId ;
   public Customer customer;

    @BeforeEach
    void  setUp(){
         customerId = UUID.randomUUID();
         customer=  Customer
                .builder()
                .id(customerId)
                .firstName("John")
                .lastName("Doe")
                .phoneNumber("87303203789329")
                .email("john.doe@gmail.com")
                .role(Role.ADMIN)
                .password("Password123")
                .address(
                        Address
                                .builder()
                                .zipCode("84932")
                                .street("28u28")
                                .houseNumber("3298290")
                                .build()
                )
                .build();
    }

    @Test
    void getCustomerById_ShouldReturnCustomer_WhenCustomerExistS(){
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));

        Customer result= customerService.getCustomerById(customerId);

        assertNotNull(result);

        assertEquals(customerId,result.getId());

        assertEquals("John",result.getFirstName());

        verify(customerRepository,times(1)).findById(customerId);


    }

    @Test
    void  shouldThrowCustomerNotFoundException_WhenCustomerDoesNotExistS(){
        when(customerRepository.findById(customerId)).thenReturn(Optional.empty());

        CustomerNotFoundException exception= assertThrows(
         CustomerNotFoundException.class,
                ()-> customerService.getCustomerById(customerId)
        );

        assertEquals("exceptions.notFound",exception.getMessage());

        verify(customerRepository,times(1)).findById(customerId);
    }


    @Test
    void  editCustomer_shouldUpdateCustomer_whenCustomerExists(){
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));
        when(customerRepository.save(customer)).thenReturn(customer);

        EditCustomerRequest editCustomerRequest= new EditCustomerRequest(
                "Peter",
                "Pan",
                "peter@pan.com"

        );

        Customer updatedCustomer= customerService.editCustomer(editCustomerRequest,customerId);
        assertNotNull(updatedCustomer);
        assertEquals("Peter",updatedCustomer.getFirstName());

    }
}

