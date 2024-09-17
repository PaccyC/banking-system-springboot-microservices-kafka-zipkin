package com.paccy.transaction.customer;


import lombok.Data;

@Data
public class CustomerResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
