package com.sushi.tuyenbeoo.authentication.service.domain.exception;

import com.sushi.tuyenbeoo.authentication.service.domain.enumf.ErrorEnum;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GenericException extends RuntimeException {
    private final String code;
    private final String description;
    private final HttpStatus statusCode;

    public GenericException(ErrorEnum errorEnum) {
        super(errorEnum.getMessage());
        this.code = errorEnum.getCode();
        this.description = errorEnum.getMessage();
        this.statusCode = errorEnum.getHttpStatus();
    }
}
