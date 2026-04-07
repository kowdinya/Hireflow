package com.hireFlow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map> handleRunTimeException(RuntimeException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("status", 500);
        error.put("message", ex.getMessage());
        return ResponseEntity.status(500).body(error);
    }
        @ExceptionHandler(HttpMessageNotReadableException.class)
                public ResponseEntity<Map<String,Object>> handleBadRequest(Exception ex){
            Map<String,Object>err = new HashMap<>();
            err.put("status",400);
            err.put("message","Invalid Request Body");
            return ResponseEntity.status(400).body(err);

        }
    }


