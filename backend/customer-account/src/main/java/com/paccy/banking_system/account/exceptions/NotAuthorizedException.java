package com.paccy.banking_system.account.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class NotAuthorizedException  extends RuntimeException{
    public NotAuthorizedException(String message) {
        super(message);
    }
}
