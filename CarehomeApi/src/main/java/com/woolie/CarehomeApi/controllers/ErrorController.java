package com.woolie.CarehomeApi.controllers;

import com.woolie.CarehomeApi.domains.dtos.MyApiErrorResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
@Slf4j
public class ErrorController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MyApiErrorResponse> handleValidation(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .findFirst()
                .orElse("Validation error");

        MyApiErrorResponse error = MyApiErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(message)
                .build();

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<MyApiErrorResponse> handleIllegalStateException(IllegalStateException ex) {
       MyApiErrorResponse error = MyApiErrorResponse.builder()
               .status(HttpStatus.CONTINUE.value())
               .message(ex.getMessage())
               .build();

       return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

//    TODO: Handle auth BadCredentialsException

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<MyApiErrorResponse> handleEntityNotFoundException(EntityNotFoundException ex) {
        MyApiErrorResponse error = MyApiErrorResponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .build();

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyApiErrorResponse> handleException(Exception ex) {
        log.error("Caught exception: ", ex);
        MyApiErrorResponse error = MyApiErrorResponse.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("An unexpected error occurred")
                .build();

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
