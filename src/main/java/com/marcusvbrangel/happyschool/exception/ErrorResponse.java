package com.marcusvbrangel.happyschool.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record ErrorResponse(
    HttpStatus httpStatusCode,
    String friendlyErrorMessage,
    String exceptionErrorMessage,
    LocalDateTime dataHoraDoErro,
    String codigoLog,
    String requestMethod,
    String requestUrl) {

    public ErrorResponse(HttpStatus httpStatusCode,
                         String friendlyErrorMessage,
                         String exceptionErrorMessage,
                         String requestMethod,
                         String requestUrl) {
        this(httpStatusCode,
            friendlyErrorMessage,
            exceptionErrorMessage,
            LocalDateTime.now(),
            UUID.randomUUID().toString(),
            requestMethod, requestUrl);
    }
}
