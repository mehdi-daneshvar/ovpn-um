package net.lashar.ovpnum.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{
    @Override
    public ResponseEntity<?> ok(String message) {
        HttpStatus status = HttpStatus.OK;
        return createMessage(status, message);
    }
    private ResponseEntity<?> createMessage(HttpStatus status, String message) {
        String response = "{\"status\":\"%d\",\"message\":\"%s\"}".formatted(status.value(), message);
        return new ResponseEntity<>(response, status);
    }
}
