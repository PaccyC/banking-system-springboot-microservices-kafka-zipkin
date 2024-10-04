package com.paccy.banking_system.customer.exceptions;


public class UnAuthenticatedException extends RuntimeException {
    public UnAuthenticatedException(String message) {
        super(message);
    }
}
