package com.example.Shop.exceptions;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

public class InvalidValueException extends RuntimeException{

    public InvalidValueException(String message) {
        super(message);
    }

    public static String createMessage(BindingResult bindingResult) {
        String message;
        Map<String, String> errors = new HashMap<>();

        bindingResult.getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        if (errors.size() > 1)
            message = "Invalid values: ";
        else
            message = "Invalid value: ";

        return message + errors;
    }
}
