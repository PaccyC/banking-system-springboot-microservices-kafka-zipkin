package com.paccy.customer.exceptions;

public class CustomerNotFoundException  extends     RuntimeException{
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
