package net.lashar.ovpnum.error.handler;

import net.lashar.ovpnum.error.ErrorResponse;
import net.lashar.ovpnum.error.exception.CityNameNullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class CityNameNullExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CityNameNullException.class)
    public ResponseEntity<ErrorResponse> cityNameNullException(
            CityNameNullException e,
            WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponse response = new ErrorResponse(status.value(), e.getMessage());
        return ResponseEntity.status(status).body(response);
    }
}
