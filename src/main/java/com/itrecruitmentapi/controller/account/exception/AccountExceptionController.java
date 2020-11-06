package com.itrecruitmentapi.controller.account.exception;


import com.itrecruitmentapi.shared.ResponseError;
import com.itrecruitmentapi.shared.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AccountExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = AccountNotFoundException.class)
    public ResponseEntity<Object> exception(AccountNotFoundException exception) {
        return ResponseError.sendResponseError(new ApiError(HttpStatus.NOT_FOUND, exception));
    }

    @ExceptionHandler(value = AccountIsExistsException.class)
    public ResponseEntity<Object> exception(AccountIsExistsException exception) {
        return ResponseError.sendResponseError(new ApiError(HttpStatus.CONFLICT, exception));
    }

    @ExceptionHandler(value = AccountIsNotExistsException.class)
    public ResponseEntity<Object> exception(AccountIsNotExistsException exception) {
        return ResponseError.sendResponseError(new ApiError(HttpStatus.NOT_FOUND, exception));
    }

    @ExceptionHandler(value = PasswordIsNotMatchException.class)
    public ResponseEntity<Object> exception(PasswordIsNotMatchException exception) {
        return ResponseError.sendResponseError(new ApiError(HttpStatus.BAD_REQUEST, exception));
    }
}
