package com.itrecruitmentapi.controller.image.exception;

import com.itrecruitmentapi.shared.ResponseError;
import com.itrecruitmentapi.shared.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ImageExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = ImageIsNotLoad.class)
    public ResponseEntity<Object> exception(ImageIsNotLoad exception) {
        return ResponseError.sendResponseError(new ApiError(HttpStatus.BAD_REQUEST, exception));
    }

    @ExceptionHandler(value = ImageIsNotRead.class)
    public ResponseEntity<Object> exception(ImageIsNotRead exception) {
        return ResponseError.sendResponseError(new ApiError(HttpStatus.BAD_REQUEST, exception));
    }

    @ExceptionHandler(value = ImageIsNotStore.class)
    public ResponseEntity<Object> exception(ImageIsNotStore exception) {
        return ResponseError.sendResponseError(new ApiError(HttpStatus.BAD_REQUEST, exception));
    }

    @ExceptionHandler(value = ImageIsNotUpload.class)
    public ResponseEntity<Object> exception(ImageIsNotUpload exception) {
        return ResponseError.sendResponseError(new ApiError(HttpStatus.EXPECTATION_FAILED, exception));
    }

    @ExceptionHandler(value = JsonImageIsNotConvert.class)
    public ResponseEntity<Object> exception(JsonImageIsNotConvert exception) {
        return ResponseError.sendResponseError(new ApiError(HttpStatus.BAD_REQUEST, exception));
    }
}