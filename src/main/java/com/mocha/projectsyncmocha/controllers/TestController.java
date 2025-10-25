package com.mocha.projectsyncmocha.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping
    public String testEndpoint() {
        return "API y conexión a BD exitosa!";
    }
}
