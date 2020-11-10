package com.itrecruitmentapi.controller.authentication.exception;

import com.itrecruitmentapi.shared.ResponseError;
import com.itrecruitmentapi.shared.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AuthenticationException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = UsernameLoginFailedException.class)
    public ResponseEntity<Object> exception(UsernameLoginFailedException exception) {
        return ResponseError.sendResponseError(new ApiError(HttpStatus.UNAUTHORIZED, exception));
    }

    @ExceptionHandler(value = PasswordLoginFailedException.class)
    public ResponseEntity<Object> exception(PasswordLoginFailedException exception) {
        return ResponseError.sendResponseError(new ApiError(HttpStatus.UNAUTHORIZED, exception));
    }
}