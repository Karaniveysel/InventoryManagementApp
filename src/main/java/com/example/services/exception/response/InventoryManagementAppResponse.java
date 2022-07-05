package com.example.services.exception.response;

import org.springframework.http.HttpStatus;

import java.util.Set;

public class InventoryManagementAppResponse<T>
{
    private final T data;
    private final String message;
    private final HttpStatus httpStatus;


    public InventoryManagementAppResponse(T data,String message, HttpStatus httpStatus) {
        this.data = data;
        this.message = message;
        this.httpStatus = httpStatus;

    }



    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public T getData() {
        return data;
    }
}