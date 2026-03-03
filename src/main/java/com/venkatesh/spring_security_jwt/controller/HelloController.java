package com.venkatesh.spring_security_jwt.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloController {
    @GetMapping("")
    public String greet(HttpServletRequest request) {
        return "Hello World" + " Your Session Id is : " + request.getSession().getId();
    }
}
