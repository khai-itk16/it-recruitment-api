package com.itrecruitmentapi.controller.job_save.exception;

import com.itrecruitmentapi.controller.job_post.exception.JobPostIsNotExistException;
import com.itrecruitmentapi.shared.ResponseError;
import com.itrecruitmentapi.shared.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class JobSaveExceptionController {
    @ExceptionHandler(value = JobSaveIsNotExistException.class)
    public ResponseEntity<Object> exception(JobSaveIsNotExistException exception) {
        return ResponseError.sendResponseError(new ApiError(HttpStatus.NOT_FOUND, exception));
    }
}
