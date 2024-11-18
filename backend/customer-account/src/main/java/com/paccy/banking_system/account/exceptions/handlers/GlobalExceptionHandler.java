package com.paccy.banking_system.account.exceptions.handlers;


import com.paccy.banking_system.account.entities.domains.ApiResponse;
import com.paccy.banking_system.account.exceptions.AccountNotFoundException;
import jakarta.ws.rs.NotAuthorizedException;
import org.springframework.context.MessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Locale;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@EnableWebMvc
public class GlobalExceptionHandler {
    private  final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(AccountNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> accountNotFoundException(AccountNotFoundException e, Locale locale){
        String errorMessage= messageSource.getMessage(e.getMessage(),null,locale);
        return  new ApiResponse<>(null,errorMessage,HttpStatus.NOT_FOUND).toResponseEntity();

    }


    @ExceptionHandler(NotAuthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public  ResponseEntity<?> unAuthorizedException(Exception e, Locale locale){
        String errorMessage= messageSource.getMessage(e.getMessage(),null,locale);
        return  new ApiResponse<>(null,errorMessage,HttpStatus.UNAUTHORIZED).toResponseEntity();
    }



}
