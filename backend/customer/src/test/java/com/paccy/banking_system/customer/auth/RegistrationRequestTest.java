package com.paccy.banking_system.customer.auth;


import com.paccy.banking_system.customer.auth.RegistrationRequest;
import com.paccy.banking_system.customer.entities.Address;
import com.paccy.banking_system.customer.entities.Role;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class RegistrationRequestTest {

    Validator validator;

    @BeforeEach
    public void  setUp(){
        ValidatorFactory validatorFactory= Validation
                .byDefaultProvider()
                .configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory();

        validator = validatorFactory.getValidator();
    }



    @Test
    public void shouldPassValidationWithValidRegistrationRequest(){

//        Arrange
        Address address = new Address();
        address.setStreet("KG-101Ave");
        address.setHouseNumber("101GH");
        address.setZipCode("839-929-232");
        RegistrationRequest registrationRequest = new RegistrationRequest(
                UUID.fromString("550e8400-e29b-41d4-a716-446655440000"),
                "Paccy",
                "Aime",
                "paccy@gmail.com",
                "732989329020",
                "Paccy123@",
                address,
                Role.MEMBER
        );

//        Act
        Set<ConstraintViolation<RegistrationRequest>> constraintViolations = validator.validate(registrationRequest);
//        Assert
        assertTrue(constraintViolations.isEmpty(),"DTO with valid data should pass");
    }


    @Test
    public void shouldFailValidationWhenAddressIsNull(){

//        Arrange
        RegistrationRequest registrationRequest = new RegistrationRequest(
                UUID.fromString("550e8400-e29b-41d4-a716-446655440000"),
                "Paccy",
                "Aime",
                "paccy@gmail.com",
                "732989329020",
                "Paccy123",
                null,
                Role.MEMBER
        );

//        Act
        Set<ConstraintViolation<RegistrationRequest>> constraintViolations = validator.validate(registrationRequest);
//        Assert
        assertFalse(constraintViolations.isEmpty(),"DTO with invalid data should fail");
    }




}
