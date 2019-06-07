package com.mgmtp.internship.experiences.controllers.api;

import com.mgmtp.internship.experiences.dto.ApiResponse;
import com.mgmtp.internship.experiences.exceptions.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseRestController {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponse> apiExceptionHandler(final ApiException ex) {
        return ResponseEntity.status(ex.getResponseStatus()).body(ApiResponse.failed(ex.getMessage()));
    }
}
