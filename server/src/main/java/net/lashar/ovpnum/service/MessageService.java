package net.lashar.ovpnum.service;

import org.springframework.http.ResponseEntity;

public interface MessageService {
    ResponseEntity<?> ok(String message);
}
