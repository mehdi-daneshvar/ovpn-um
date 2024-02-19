package net.lashar.ovpnum.error.handler;

import net.lashar.ovpnum.error.ErrorResponse;
import net.lashar.ovpnum.error.exception.StateNameNullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class StateNameNullExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(StateNameNullException.class)
    public ResponseEntity<ErrorResponse> stateNameNullException(
            StateNameNullException e,
            WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponse response = new ErrorResponse(status.value(), e.getMessage());
        return ResponseEntity.status(status).body(response);
    }
}
