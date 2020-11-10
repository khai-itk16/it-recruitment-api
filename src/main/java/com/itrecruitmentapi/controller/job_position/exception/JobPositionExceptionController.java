package com.itrecruitmentapi.controller.job_position.exception;

import com.itrecruitmentapi.shared.ResponseError;
import com.itrecruitmentapi.shared.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class JobPositionExceptionController {
    @ControllerAdvice
    public class JobPostExceptionController extends ResponseEntityExceptionHandler {
        @ExceptionHandler(value = JobPositionIsNotExistException.class)
        public ResponseEntity<Object> exception(JobPositionIsNotExistException exception) {
            return ResponseError.sendResponseError(new ApiError(HttpStatus.NOT_FOUND, exception));
        }
    }

}
