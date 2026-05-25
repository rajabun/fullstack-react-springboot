package com.eazybytes.eazystore.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.eazybytes.eazystore.dto.ErrorResponseDto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class) //Handle all exceptions (Exception is Superclass)
    public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception exception, WebRequest webRequest) {
        HttpStatus errorCode = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
            webRequest.getDescription(false),
            errorCode,
            exception.getMessage(),
            LocalDateTime.now()
        );
        // return ResponseEntity.status(errorCode).body(errorResponseDto); //other way to return response entity
        return new ResponseEntity<>(errorResponseDto, errorCode);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class) //Handle all exceptions (Exception is Superclass)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException exception, WebRequest webRequest) {
        Map<String, String> errors = new HashMap<>();
        List<FieldError> fieldErrorList = exception.getBindingResult().getFieldErrors();
        fieldErrorList.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(ConstraintViolationException.class) //Handle all exceptions (Exception is Superclass)
    public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException exception, WebRequest webRequest) {
        Map<String, String> errors = new HashMap<>();
        Set<ConstraintViolation<?>> constraintViolationSet = exception.getConstraintViolations();
        constraintViolationSet.forEach(constraintViolation -> 
            errors.put(constraintViolation.getPropertyPath().toString(),
            constraintViolation.getMessage()));
        return ResponseEntity.badRequest().body(errors);
    }
}
