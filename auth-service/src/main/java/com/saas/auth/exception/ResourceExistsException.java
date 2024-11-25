package com.saas.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ResourceExistsException extends RuntimeException {
    public ResourceExistsException(String message) {
        super(message);
    }
}
