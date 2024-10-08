package com.paccy.banking_system.customer.auth;

import com.paccy.banking_system.customer.entities.Address;
import com.paccy.banking_system.customer.entities.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record RegistrationRequest(

        Integer id,
        @NotNull(message = "firstName is required")
        String firstName,
        @NotNull(message = "lastName is required")
        String lastName,
        @NotNull(message = "email is required")
        @Email(message = "email must be a valid email")
        String email,
        @NotNull(message = "phoneNumber is required")
        String phoneNumber,
        @NotNull(message = "password is required")
        @Min(value = 8,message = "Password must be atleast 8 characters")
        String password,
        @NotNull(message = "address is required")
        Address address,

        @NotNull(message =" Role is required")
        Role role
) {
}
