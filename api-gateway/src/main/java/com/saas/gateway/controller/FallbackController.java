package com.saas.gateway.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FallbackController {

    @RequestMapping("/fallback/{serviceName}")
    public ResponseEntity<String> serviceFallback(
            @PathVariable String serviceName) {

        String name = modifiedServiceName(serviceName);
        log.info("{} is unavailable.", name);
        return ResponseEntity.status(503).body(name + " is unavailable. Please try again later!");
    }

    private String modifiedServiceName(String serviceName) {
        String name = serviceName.replace("-", " ");
        StringBuilder capitalized = new StringBuilder();
        if (!name.isEmpty()) {
            capitalized
                    .append(Character.toUpperCase(name.charAt(0)))
                    .append(name.substring(1).toLowerCase());
        }
        return capitalized.toString().trim();
    }
}
