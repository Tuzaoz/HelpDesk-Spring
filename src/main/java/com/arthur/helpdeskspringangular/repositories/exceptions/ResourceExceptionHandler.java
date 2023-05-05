package com.arthur.helpdeskspringangular.repositories.exceptions;

import com.arthur.helpdeskspringangular.services.exceptions.ObjectNotFoundExcpetion;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ObjectNotFoundExcpetion.class)
    public ResponseEntity<StandartError> objectNotFoundException(ObjectNotFoundExcpetion ex, HttpServletRequest request){
        StandartError error = new StandartError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), request.getRequestURI() );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
