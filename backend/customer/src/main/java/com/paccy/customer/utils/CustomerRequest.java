package com.paccy.customer.utils;

import com.paccy.customer.entities.Address;
import com.paccy.customer.entities.Customer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        Integer id,
        @NotNull(message = "firstName is required")

        String firstName,
        @NotNull(message = "firstName is required")
        String lastName,
        @NotNull(message = "lastName is required")
        String email,
        @NotNull(message = "email is required")
        @Email(message = "email must be a valid email")
        String phoneNumber,
        @NotNull(message = "address is required")
        Address address

) {



}
