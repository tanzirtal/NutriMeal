package com.passionproject.nutrimealplanner.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecipesNotFoundException extends EntityNotFoundException {
    public RecipesNotFoundException() {
    }

    public RecipesNotFoundException(String message) {
        super(message);
    }
}
