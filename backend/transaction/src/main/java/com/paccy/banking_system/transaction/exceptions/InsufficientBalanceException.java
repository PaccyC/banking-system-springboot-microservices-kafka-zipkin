package com.paccy.banking_system.transaction.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@AllArgsConstructor
@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InsufficientBalanceException extends RuntimeException{
    private String message;
    private final Date timestamp;
    private Object[] args;
    public InsufficientBalanceException(Object... args) {
        this.args=args;
        this.timestamp=new Date();
    }
}
