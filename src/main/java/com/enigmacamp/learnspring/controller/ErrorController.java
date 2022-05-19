package com.enigmacamp.learnspring.controller;


import com.enigmacamp.learnspring.exception.NotFoundException;
import com.enigmacamp.learnspring.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(NotFoundException exception){
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ErrorResponse errorResponse = new ErrorResponse(
                httpStatus.value(),httpStatus.getReasonPhrase(),exception.getMessage()
        );
        return new ResponseEntity<>(errorResponse,httpStatus);
    }

}
