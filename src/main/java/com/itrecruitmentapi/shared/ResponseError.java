package com.itrecruitmentapi.shared;

import com.itrecruitmentapi.shared.model.ApiError;
import org.springframework.http.ResponseEntity;

public class ResponseError {
    public static ResponseEntity<Object> sendResponseError(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
