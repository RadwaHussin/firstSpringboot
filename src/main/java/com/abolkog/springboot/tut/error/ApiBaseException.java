package com.abolkog.springboot.tut.error;

import org.springframework.http.HttpStatus;

public abstract class ApiBaseException extends RuntimeException { // all common in exception
    public ApiBaseException(String message) {
        super(message);
    }

    
    public abstract HttpStatus getStatusCode();
}
