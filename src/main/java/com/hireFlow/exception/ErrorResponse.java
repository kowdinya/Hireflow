package com.hireFlow.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
@Getter
@Setter
public class ErrorResponse {
    private int status;
    private String message;
    private Map<String, List<String>> error;
    public ErrorResponse(int status, String message, Map<String,List<String>> error){
        this.status=status;
        this.message=message;
        this.error=error;

    }
    public ErrorResponse(int status, String message){
        this.status=status;
        this.message=message;
    }

}
