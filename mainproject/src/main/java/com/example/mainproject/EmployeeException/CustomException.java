package com.example.mainproject.EmployeeException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.util.Date;

@ControllerAdvice
public class CustomException {

    @ExceptionHandler
    public ResponseEntity handleEmployeeNotFoundException(EmployeeNotFoundException exception, WebRequest webRequest){

        ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(),exception.getMessage(),webRequest.getDescription(false));
        return new  ResponseEntity(exceptionDetails,HttpStatus.NOT_FOUND);
    }
}

