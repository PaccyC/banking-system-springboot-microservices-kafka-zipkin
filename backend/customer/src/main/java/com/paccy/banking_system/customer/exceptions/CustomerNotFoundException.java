package com.paccy.banking_system.customer.exceptions;

//Exception handler
public class CustomerNotFoundException  extends     RuntimeException{
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
