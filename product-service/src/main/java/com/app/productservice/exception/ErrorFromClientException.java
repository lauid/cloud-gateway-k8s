package com.app.productservice.exception;

import lombok.Data;

@Data
public class ErrorFromClientException extends RuntimeException{

    private String errorStatus;
    public ErrorFromClientException(String message, String errorStatus){
        super(message);
        this.errorStatus = errorStatus;
    }
}
