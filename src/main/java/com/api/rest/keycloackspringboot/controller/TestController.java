package com.api.rest.keycloackspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hello-1")
    public String helloAdmin(){
        return "Hello SpringBoot with keycloak - ADMIN";
    }

    @GetMapping("/hello-2")
    public String helloUser(){
        return "Hello SpringBoot with keycloak - USER";
    }
}
