package com.paccy.banking_system.transaction.exceptions;

public class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException( String message) {
        super(message);
    }
}
