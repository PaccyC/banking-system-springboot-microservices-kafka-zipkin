package com.paccy.banking_system.account.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
@AllArgsConstructor
public class AccountNotFoundException extends RuntimeException{

    private String message;
    private final Date timestamp;
    private Object[] args;
    public AccountNotFoundException(Object... args) {
        this.args= args;
        this.timestamp = new Date();

    }
}
