package com.eazybytes.eazystore.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.eazybytes.eazystore.dto.ErrorResponseDto;

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

}
