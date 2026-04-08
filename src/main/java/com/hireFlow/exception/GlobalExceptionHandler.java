package com.hireFlow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRunTimeException(RuntimeException ex) {
        ErrorResponse error = new ErrorResponse(
                500,
                ex.getMessage()
        );
        return ResponseEntity.status(500).body(error);
    }
        @ExceptionHandler(HttpMessageNotReadableException.class)
                public ResponseEntity<ErrorResponse> handleBadRequest(HttpMessageNotReadableException ex) {
            ErrorResponse error = new ErrorResponse(
                    400,
                    "Invalid Request Body"
            );
            return ResponseEntity.status(400).body(error);

        }
        @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex){
        Map<String, List<String>>errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                {
                    String field = error.getField();
                    String message = error.getDefaultMessage();
                    errors.computeIfAbsent(field,k-> new ArrayList<>()).add(message);
                }
        );
        ErrorResponse response = new ErrorResponse(
                400,
                "Validation Failed",
                errors
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }


