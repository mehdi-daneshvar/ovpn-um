package net.lashar.ovpnum.error.handler;

import net.lashar.ovpnum.error.ErrorResponse;
import net.lashar.ovpnum.error.exception.StateNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
@ControllerAdvice
@ResponseStatus
public class StateNotExistsExceptionHandler {
    @ExceptionHandler(StateNotExistsException.class)
    public ResponseEntity<ErrorResponse> stateNotExistsException(
            StateNotExistsException e,
            WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse response = new ErrorResponse(status.value(), e.getMessage());
        return ResponseEntity.status(status).body(response);
    }
}
