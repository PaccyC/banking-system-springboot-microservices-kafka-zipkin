package com.paccy.banking_system.customer.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;


//Exception handler
@ResponseStatus(HttpStatus.NOT_FOUND)
@AllArgsConstructor
@Getter
public class CustomerNotFoundException  extends     RuntimeException{

    private String message = "exceptions.notFound";
    private final Date timestamp;
    private Object[] args;
    public CustomerNotFoundException(Object... args) {

      this.args= args;
      this.timestamp= new Date();

    }
}
