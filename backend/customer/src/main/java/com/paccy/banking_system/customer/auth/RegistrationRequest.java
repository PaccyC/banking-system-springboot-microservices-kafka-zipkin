package com.paccy.banking_system.customer.auth;

import com.paccy.banking_system.customer.entities.Address;
import com.paccy.banking_system.customer.entities.Role;
import jakarta.validation.constraints.*;

import java.util.UUID;

public record RegistrationRequest(

        UUID id,
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
        @Size(min = 8,message = "Password must be atleast 8 characters")
        @Pattern(
                regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
                message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character"
        )
        String password,
        @NotNull(message = "address is required")
        Address address,

        @NotNull(message =" Role is required")
        Role role
) {
}
