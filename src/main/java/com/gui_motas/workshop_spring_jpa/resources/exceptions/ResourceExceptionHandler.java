package com.gui_motas.workshop_spring_jpa.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gui_motas.workshop_spring_jpa.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandartError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {

        String error = "Resource Not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandartError se = new StandartError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(se);
    }

}
