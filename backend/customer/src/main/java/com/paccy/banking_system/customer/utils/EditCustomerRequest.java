package com.paccy.banking_system.customer.utils;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public record EditCustomerRequest(
        @NotNull(message = "firstName is required")
        String firstName,
        @NotNull(message = "lastName is required")
        String lastName,

        @NotNull(message = "email is required")
        @Email(message = "email must be a valid email")
        String email

) {



}
