package com.paccy.banking_system.customer;

public record CustomerResponse(
         Integer id,
         String firstName,
         String lastName,
         String email,
         String phoneNumber
) {
}

