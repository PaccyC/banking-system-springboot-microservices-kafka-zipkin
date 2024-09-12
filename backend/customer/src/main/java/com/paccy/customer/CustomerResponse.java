package com.paccy.customer;

public record CustomerResponse(
         Integer id,
         String firstName,
         String lastName,
         String email,
         String phoneNumber
) {
}

