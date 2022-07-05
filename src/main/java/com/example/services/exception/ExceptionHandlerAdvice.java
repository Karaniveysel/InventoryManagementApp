package com.example.services.exception;

import com.example.services.exception.response.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ResourceException.class)
    public static <T>ResponseEntity<T> generateResponse(ResourceException e) {
        HttpStatus badRequest=HttpStatus.BAD_REQUEST;
        ApiException apiException=new ApiException(
                 e.getMessage()
                ,null
                ,badRequest
                ,ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity(apiException, badRequest);
    }
}