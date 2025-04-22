package com.FindMyRoom.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.HttpRequestMethodNotSupportedException;
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
}
