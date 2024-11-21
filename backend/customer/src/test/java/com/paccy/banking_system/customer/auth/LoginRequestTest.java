package com.paccy.banking_system.customer.auth;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginRequestTest {
    public Validator validator;


    @BeforeEach
    void setUp() {
        ValidatorFactory validatorFactory= Validation.byDefaultProvider()
                .configure()
                .messageInterpolator( new ParameterMessageInterpolator())
                .buildValidatorFactory();

        validator= validatorFactory.getValidator();
    }


    @Test
    void shouldPassValidationWithValidLoginRequest(){
//        Arrange
        LoginRequest loginRequest = new LoginRequest(
                "paccy@gmail.com",
                "Paccy123#@$"
        );
//        Act
        Set<ConstraintViolation<LoginRequest>> constraintViolations= validator.validate(loginRequest);

//        Assert

        assertTrue(constraintViolations.isEmpty(),"VALID DTO SHOULD PASS VALIDATION");

    }

}
