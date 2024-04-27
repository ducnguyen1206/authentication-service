package com.sushi.tuyenbeoo.authentication.service.domain.config;


import com.sushi.tuyenbeoo.authentication.service.domain.exception.GenericException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseBody
@Log4j2
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({GenericException.class})
    public ResponseEntity<Object> throwException(GenericException e) {
        log.error(e.getCode() + " - " + e.getMessage(), e.getCause());
        Error error = new Error();
        error.setCode(e.getCode());
        error.setDescription(e.getMessage());
        return ResponseEntity.status(e.getStatusCode().value()).body(error);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Error {
        private String code;
        private String description;
    }
}
