package com.itrecruitmentapi.controller.skill.exception;

import com.itrecruitmentapi.shared.ResponseError;
import com.itrecruitmentapi.shared.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SkillExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = SkillIsNotExistException.class)
    public ResponseEntity<Object> exception(SkillIsNotExistException exception) {
        return ResponseError.sendResponseError(new ApiError(HttpStatus.NOT_FOUND, exception));
    }

    @ExceptionHandler(value = SkillIsExistException.class)
    public ResponseEntity<Object> exception(SkillIsExistException exception) {
        return ResponseError.sendResponseError(new ApiError(HttpStatus.NOT_FOUND, exception));
    }
}
