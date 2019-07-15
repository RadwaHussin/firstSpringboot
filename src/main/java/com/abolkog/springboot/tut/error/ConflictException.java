package com.abolkog.springboot.tut.error;

import org.springframework.http.HttpStatus;

public class ConflictException  extends ApiBaseException  { // check if the name is repeated

    public ConflictException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() { return HttpStatus.CONFLICT; }
}

