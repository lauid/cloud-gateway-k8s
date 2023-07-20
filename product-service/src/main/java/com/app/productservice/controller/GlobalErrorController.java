package com.app.productservice.controller;


import com.app.productservice.exception.ErrorFromClientException;
import com.app.productservice.exception.MessageNotfoundException;
import com.app.productservice.model.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.app.productservice.constant.ConstantValue.*;

@Slf4j
@RestControllerAdvice
public class GlobalErrorController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MessageNotfoundException.class)
    public ResponseEntity<ErrorResponse> handleNotfoundException(MessageNotfoundException e){
        log.info("handleNotfoundException.error = {} ",e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorResponse.builder()
                        .errorMessage(NOT_FOUND_MESSAGE)
                        .errorStatus(NOT_FOUND_STATUS)
                        .build());
    }

    @ExceptionHandler(ErrorFromClientException.class)
    public ResponseEntity<ErrorResponse> handleErrorFromClient(ErrorFromClientException e){
        log.info("handleErrorFromClient.error = {} ",e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorResponse.builder()
                        .errorMessage(e.getMessage())
                        .errorStatus(e.getErrorStatus())
                        .build());
    }
}
