package com.projectbackend.projectbackend.exception;

import org.springframework.http.HttpStatus;

public class TnpApiException extends RuntimeException{
    private HttpStatus status;
    private String message;

    public TnpApiException(HttpStatus status,String message){
        this.status=status;
        this.message=message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
