package com.paccy.banking_system.customer.exceptions.handlers;


import com.paccy.banking_system.customer.entities.domain.ApiResponse;
import com.paccy.banking_system.customer.exceptions.CustomerNotFoundException;
import com.paccy.banking_system.customer.exceptions.JwtExpiredException;
import com.paccy.banking_system.customer.exceptions.UnAuthenticatedException;
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

    private final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> customerNotFoundException(CustomerNotFoundException e, Locale locale){
        String errorMessage= messageSource.getMessage(e.getMessage(),null,locale);
        return  new ApiResponse<>(null,errorMessage,HttpStatus.NOT_FOUND).toResponseEntity();

    }

    @ExceptionHandler(JwtExpiredException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<?> jwtExpiredException(JwtExpiredException e, Locale locale){
        String errorMessage= messageSource.getMessage(e.getMessage(),null,locale);
        return  new  ApiResponse<>(null,errorMessage,HttpStatus.UNAUTHORIZED).toResponseEntity();
    }


    @ExceptionHandler(UnAuthenticatedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public  ResponseEntity<?> unAuthenticatedException(UnAuthenticatedException e, Locale locale){
        String errorMessage= messageSource.getMessage(e.getMessage(),null,locale);
        return  new ApiResponse<>(null,errorMessage,HttpStatus.UNAUTHORIZED).toResponseEntity();
    }
}
