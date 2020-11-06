package com.itrecruitmentapi.controller.job_apply.exception;

import com.itrecruitmentapi.shared.ResponseError;
import com.itrecruitmentapi.shared.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class JobApplyExceptionController {
    @ExceptionHandler(value = JobApplyIsNotExistException.class)
    public ResponseEntity<Object> exception(JobApplyIsNotExistException exception) {
        return ResponseError.sendResponseError(new ApiError(HttpStatus.NOT_FOUND, exception));
    }
}
