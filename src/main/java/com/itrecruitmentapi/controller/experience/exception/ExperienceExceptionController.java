package com.itrecruitmentapi.controller.experience.exception;

import com.itrecruitmentapi.shared.ResponseError;
import com.itrecruitmentapi.shared.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExperienceExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = ExperienceIsNotExistException.class)
    public ResponseEntity<Object> exception(ExperienceIsNotExistException exception) {
        return ResponseError.sendResponseError(new ApiError(HttpStatus.NOT_FOUND, exception));
    }

    @ExceptionHandler(value = ExperienceIsExistException.class)
    public ResponseEntity<Object> exception(ExperienceIsExistException exception) {
        return ResponseError.sendResponseError(new ApiError(HttpStatus.CONFLICT, exception));
    }
}
