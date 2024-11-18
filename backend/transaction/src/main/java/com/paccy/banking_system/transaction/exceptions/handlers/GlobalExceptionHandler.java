package com.paccy.banking_system.transaction.exceptions.handlers;


import com.paccy.banking_system.transaction.entities.domain.ApiResponse;
import com.paccy.banking_system.transaction.exceptions.InsufficientBalanceException;
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

@EnableWebMvc
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    private final MessageSource messageSource;
    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }



    @ExceptionHandler(InsufficientBalanceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> insufficientFundsException(InsufficientBalanceException exception, Locale locale) {
        String errorMessage= messageSource.getMessage(exception.getMessage(),null,locale);
        return  new ApiResponse<>(null,errorMessage, HttpStatus.BAD_REQUEST).toResponseEntity();
    }
}
