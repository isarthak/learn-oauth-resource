package com.example.learnoauthresource.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @GetMapping("/hello")
    public String helloResource() {
        return "Hello from RESOURCE";
    }

    @GetMapping("/sarthak")
    public String sarthak() {
        return "Hello from sarthak";
    }

}
