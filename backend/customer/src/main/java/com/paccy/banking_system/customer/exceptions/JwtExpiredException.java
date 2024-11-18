package com.paccy.banking_system.customer.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@Getter
@AllArgsConstructor
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class JwtExpiredException extends  RuntimeException{
    private String message;
    private final Date timestamp;
    private Object[] args;

    public JwtExpiredException(Object... args){
        this.args= args;
        this.timestamp= new Date();
    }
}
