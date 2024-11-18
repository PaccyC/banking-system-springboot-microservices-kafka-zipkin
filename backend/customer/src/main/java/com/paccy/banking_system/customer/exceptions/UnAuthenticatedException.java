package com.paccy.banking_system.customer.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@Getter
@ResponseStatus(HttpStatus.UNAUTHORIZED)
@AllArgsConstructor
public class UnAuthenticatedException extends RuntimeException {
       private String message;
       private  Object[] args;
       private final Date timestamp;

       public  UnAuthenticatedException( Object... args) {
           this.args = args;
           this.timestamp = new Date();
       }


}
