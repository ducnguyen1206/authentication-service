package com.sushi.tuyenbeoo.authentication.service.domain.enumf;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorEnum {
    USER_NAME_NOT_FOUND("EC-001", "Role not found", HttpStatus.UNAUTHORIZED),
    ROLE_NOT_FOUND("EC-002", "Role not found", HttpStatus.FORBIDDEN);

    private final String code;
    private final String message;

    private final HttpStatus httpStatus;

    ErrorEnum(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
