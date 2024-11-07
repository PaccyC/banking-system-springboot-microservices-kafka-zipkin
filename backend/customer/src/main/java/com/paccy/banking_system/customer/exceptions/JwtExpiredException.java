package com.paccy.banking_system.customer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class JwtExpiredException extends  RuntimeException{
    public JwtExpiredException(String message) {
        super(message);
    }
}