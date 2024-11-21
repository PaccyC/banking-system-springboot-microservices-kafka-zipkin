package com.paccy.banking_system.customer.repositories;


import com.paccy.banking_system.customer.entities.Address;
import com.paccy.banking_system.customer.entities.Customer;
import com.paccy.banking_system.customer.entities.Role;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest(excludeAutoConfiguration = org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration.class)
@TestPropertySource(locations = "classpath:application-test.yml")
public class CustomerRepositoryTest {


    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        Customer customer = Customer

                .builder()
                .id(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"))

                .email("paccy@gmail.com")
                .address(Address
                        .builder()
                        .houseNumber("38792")
                        .street("KG-120")
                        .zipCode("8389-3883-2829")
                        .build())
                .role(Role.ADMIN)
                .firstName("Paccy")
                .lastName("Bank")
                .password("Paccy123@12")
                .phoneNumber("283729919378")
                .build();

        customerRepository.save(customer);

    }

    @Test
    void shouldFindCustomerById() {

        Optional<Customer> customer = customerRepository.findById(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"));
        assertTrue(customer.isPresent(), "Customer  is not found");
    }


    @Test
    void  shouldNotFindCustomerWithNonExistentId(){
        Optional<Customer> customer = customerRepository.findById(UUID.randomUUID());
        assertFalse(customer.isPresent(), "Customer  is not found");
    }


    @Test
    void shouldCreateCustomer() {
        Customer customer = Customer
                .builder()
                .id(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"))
                .email("paccy2@gmail.com")
                .address(Address
                        .builder()
                        .houseNumber("3792")
                        .street("KG-20")
                        .zipCode("8389-3883-829")
                        .build())
                .role(Role.ADMIN)
                .firstName("Pacifique")
                .lastName("Bank")
                .password("Paccy123@12")
                .phoneNumber("283729919378")
                .build();
        customerRepository.save(customer);

        assertEquals(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"), (UUID) customer.getId());
    }

    @Test
    void shouldGetCustomerByEmail() {
        Optional<Customer> customer = customerRepository.findByEmail("paccy@gmail.com");
        assertTrue(customer.isPresent(), "Customer  is not found");

    }

    @Test
    void shouldReturnErrorWhenEmailDoesNotExist() {
        Optional<Customer> customer = customerRepository.findByEmail("paccy2@gmail.com");
        assertFalse(customer.isPresent(), "Customer  is not found");

    }

}


