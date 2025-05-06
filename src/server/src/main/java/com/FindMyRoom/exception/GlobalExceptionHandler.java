package com.FindMyRoom.exception;

import com.FindMyRoom.dto.response.ApiResponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public String handlerMethodAllowed(@NotNull HttpServletRequest request, @NotNull Exception ex) {
        logger.info("HttpRequestMethodNotSupportedException " + ex.getMessage());
        logger.log(Level.SEVERE, request.getRequestURI());
        return "redirect:/access-denied";
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleEntityNotFoundException(@NotNull EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                null
        ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<String>> handleValidationException(@NotNull MethodArgumentNotValidException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(
                HttpStatus.BAD_REQUEST.value(),
                ex.getBindingResult().getAllErrors().getFirst().getDefaultMessage(),
                null
        ));
    }
}