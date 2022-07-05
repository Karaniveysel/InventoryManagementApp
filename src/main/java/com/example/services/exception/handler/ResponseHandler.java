package com.example.services.exception.handler;

import com.example.services.exception.response.WarehouseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler<T> {
    public static <T>ResponseEntity<T> generateResponse(String message, HttpStatus status, T data) {
        WarehouseResponse response=new WarehouseResponse(
                 data
                ,message
                ,status
        );
        return new ResponseEntity(response,status);
    }

    public static <T>ResponseEntity<T> generateResponse(HttpStatus status, T data) {
        WarehouseResponse response=new WarehouseResponse(
                data
                ,status.getReasonPhrase()
                ,status
        );
        return new ResponseEntity(response,status);
    }

    public static <T>ResponseEntity<T> generateResponse(T data) {
        HttpStatus status=HttpStatus.OK;
        WarehouseResponse response=new WarehouseResponse(
                data
                ,String.valueOf(status.OK.value())
                ,status
        );
        return new ResponseEntity(response,HttpStatus.OK);
    }




}
