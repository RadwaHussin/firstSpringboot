package com.abolkog.springboot.tut.error;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;



public class ValidationDetails {

    private List<String> errors;

    private String uri;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy hh:mm:ss")
    private Date timestamp;

    public ValidationDetails(){
        this.timestamp= new Date ();
        this.errors = new ArrayList<>();
    }

    public void addError(String error){ //to add our errors in arraylist
        this.errors.add(error);
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
