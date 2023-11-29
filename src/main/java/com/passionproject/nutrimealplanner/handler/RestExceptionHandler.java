package com.passionproject.nutrimealplanner.handler;

import com.passionproject.nutrimealplanner.dto.Detail;
import com.passionproject.nutrimealplanner.dto.ErrorDetailAlt;
import com.passionproject.nutrimealplanner.dto.ValidationError;
import com.passionproject.nutrimealplanner.exception.NutritionNotFoundException;
import com.passionproject.nutrimealplanner.exception.RecipesNotFoundException;
import com.passionproject.nutrimealplanner.exception.UserNotFoundException;
import com.passionproject.nutrimealplanner.exception.WeightEntryNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(RecipesNotFoundException.class)
    public ResponseEntity<?> handleRecipesNotFoundException(RecipesNotFoundException rnfe) {
        Detail detail = new Detail();
        detail.setCode(HttpStatus.NOT_FOUND.value());
        detail.setMessage(rnfe.getMessage());

        return new ResponseEntity<>(detail, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NutritionNotFoundException.class)
    public ResponseEntity<?> handleNutritionNotFoundException(NutritionNotFoundException nnfe) {
        Detail detail = new Detail();
        detail.setCode(HttpStatus.NOT_FOUND.value());
        detail.setMessage(nnfe.getMessage());

        return new ResponseEntity<>(detail, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException unfe) {
        Detail detail = new Detail();
        detail.setCode(HttpStatus.NOT_FOUND.value());
        detail.setMessage(unfe.getMessage());

        return new ResponseEntity<>(detail, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WeightEntryNotFound.class)
    public ResponseEntity<?> handleWeightEntryNotFound(WeightEntryNotFound wenf) {
        Detail detail = new Detail();
        detail.setCode(HttpStatus.NOT_FOUND.value());
        detail.setMessage(wenf.getMessage());

        return new ResponseEntity<>(detail, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorDetailAlt errorDetail = new ErrorDetailAlt();
        errorDetail.setTitle("Message Not Readable");
        errorDetail.setStatus(status.value());
        errorDetail.setDetail(ex.getMessage());
        errorDetail.setTimeStamp(Calendar.getInstance().getTime());
        errorDetail.setDeveloperMessage(ex.getClass().getName());

        return handleExceptionInternal(ex, errorDetail, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorDetailAlt errorDetail = new ErrorDetailAlt();
        errorDetail.setTitle("Validation Failed");
        errorDetail.setStatus(HttpStatus.BAD_REQUEST.value());

        errorDetail.setDetail("Input validation failed");
        errorDetail.setTimeStamp(Calendar.getInstance().getTime());
        errorDetail.setDeveloperMessage(ex.getClass().getName());
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        for (FieldError fe : fieldErrors) {
            List<ValidationError> validationErrorsList = errorDetail.getErrors().get(fe.getField());
            if (validationErrorsList == null) {
                validationErrorsList = new ArrayList<>();
                errorDetail.getErrors().put(fe.getField(), validationErrorsList);
            }
            ValidationError validationError = new ValidationError();
            validationError.setCode(fe.getCode());
            validationError.setMessage(messageSource.getMessage(fe, null));
            validationErrorsList.add(validationError);
        }

        return handleExceptionInternal(ex, errorDetail, headers, status, request);

    }
}
