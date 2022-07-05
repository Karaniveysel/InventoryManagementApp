package com.example.services.exception.handler;

import com.example.services.exception.response.InventoryManagementAppResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ResponseHandler<T> {
    public static <T>ResponseEntity<T> generateResponse(String message, HttpStatus status, T data) {
        InventoryManagementAppResponse response=new InventoryManagementAppResponse(
                 data
                ,message
                ,status
        );
        return new ResponseEntity(response,status);
    }

    public static <T>ResponseEntity<T> generateResponse(HttpStatus status, T data) {
        InventoryManagementAppResponse response=new InventoryManagementAppResponse(
                data
                ,status.getReasonPhrase()
                ,status
        );
        return new ResponseEntity(response,status);
    }

    public static <T>ResponseEntity<T> generateResponse(T data) {
        HttpStatus status=HttpStatus.OK;
        InventoryManagementAppResponse response=new InventoryManagementAppResponse(
                data
                ,String.valueOf(status.OK.value())
                ,status
        );
        return new ResponseEntity(response,HttpStatus.OK);
    }




}
