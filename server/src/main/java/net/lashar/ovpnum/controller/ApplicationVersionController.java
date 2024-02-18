package net.lashar.ovpnum.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ApplicationVersionController {
    @Value("${ovpnum.version}")
    private String appVersion;

    @GetMapping("/version")
    public String version() {
        return "{\"version\":\"%s\"}".formatted(appVersion);
    }
}
