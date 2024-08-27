package com.paccy.customer.entities;


import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.validation.annotation.Validated;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Validated
@Embeddable
public class Address {
    private String street;
    private String houseNumber;
    private String zipCode;
}
