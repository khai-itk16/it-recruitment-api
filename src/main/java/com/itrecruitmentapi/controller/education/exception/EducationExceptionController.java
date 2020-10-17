package com.itrecruitmentapi.controller.education.exception;

import com.itrecruitmentapi.shared.ResponseError;
import com.itrecruitmentapi.shared.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EducationExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = EducationIsNotExistException.class)
    public ResponseEntity<Object> exception(EducationIsNotExistException exception) {
        return ResponseError.sendResponseError(new ApiError(HttpStatus.NOT_FOUND, exception));
    }

    @ExceptionHandler(value = EducationIsExistException.class)
    public ResponseEntity<Object> exception(EducationIsExistException exception) {
        return ResponseError.sendResponseError(new ApiError(HttpStatus.CONFLICT, exception));
    }
}
