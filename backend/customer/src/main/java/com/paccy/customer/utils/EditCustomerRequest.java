package com.paccy.customer.utils;

import com.paccy.customer.entities.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

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
