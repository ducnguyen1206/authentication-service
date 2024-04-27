package com.authentication.service.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GenericException extends RuntimeException {
    private final String code;
    private final String description;
    private final HttpStatus statusCode;

    public GenericException(String code, String description, HttpStatus statusCode) {
        super(description);
        this.code = code;
        this.description = description;
        this.statusCode = statusCode;
    }
}
