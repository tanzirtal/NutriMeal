package com.passionproject.nutrimealplanner.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class InvalidTypeException extends HttpMessageNotReadableException {
    public InvalidTypeException(String msg) {
        super(msg);
    }
}
