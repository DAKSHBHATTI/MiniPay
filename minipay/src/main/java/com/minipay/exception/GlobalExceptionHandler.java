package com.minipay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.minipay.dto.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(InsufficientBalanceException.class)
public ResponseEntity<ErrorResponse>handleInsufficientBalanceException(InsufficientBalanceException e){
    ErrorResponse error=new ErrorResponse(
            400,e.getMessage(), LocalDateTime.now().toString());
return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse>handleUserNotFoundException(UserNotFoundException e){
        ErrorResponse error=new ErrorResponse(
                404,e.getMessage(), LocalDateTime.now().toString());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(InvalidTransactionException .class)
    public ResponseEntity<ErrorResponse>handleInvalidTransactionException (InvalidTransactionException  e){
        ErrorResponse error=new ErrorResponse(
                400,e.getMessage(), LocalDateTime.now().toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse>handleGenericException(Exception e){
        ErrorResponse error=new ErrorResponse(
                500,"An unexpected error occurred", LocalDateTime.now().toString());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }


}
