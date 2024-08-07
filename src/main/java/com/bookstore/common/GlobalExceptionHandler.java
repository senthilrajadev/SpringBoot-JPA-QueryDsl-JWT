package com.bookstore.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity handleException(Exception ex){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        apiResponse.setError(ex);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
    }

//    @ExceptionHandler
//    public ResponseEntity badRequestException(BadRequestException ex){
//        APIResponse apiResponse = new APIResponse();
//
//        apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
//        apiResponse.setError(ex);
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
//    }
    @ExceptionHandler
    public ResponseEntity handleAccessDeniedException(AccessDeniedException ex){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        apiResponse.setError("Token is invalid");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(apiResponse);

    }

}
