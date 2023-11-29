package com.passionproject.nutrimealplanner.exception;

import javax.persistence.EntityNotFoundException;

public class WeightEntryNotFound extends EntityNotFoundException {
    public WeightEntryNotFound() {
    }

    public WeightEntryNotFound(String message) {
        super(message);
    }
}
