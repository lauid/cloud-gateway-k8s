package com.app.categoryservice.controller;

import com.app.categoryservice.exception.MessageNotFoundException;
import com.app.categoryservice.model.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.app.categoryservice.constant.ConstantValue.*;

@Slf4j
@RestControllerAdvice
public class GlobalErrorController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MessageNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotfoundException(MessageNotFoundException e){
        log.info("handleNotfoundException.error = {} ",e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorResponse.builder()
                        .errorMessage(NOT_FOUND_MESSAGE)
                        .errorStatus(NOT_FOUND_STATUS)
                        .build());
    }


}
