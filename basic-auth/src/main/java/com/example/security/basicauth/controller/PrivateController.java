package com.example.security.basicauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private/")
public class PrivateController {

    @GetMapping("")
    public String helloWorldPrivate(){
        return "Hello from private endpoint";
    }

    @GetMapping("user")
    public String helloWorldUserPrivate(){
        return "Hello from private user endpoint";
    }

    @GetMapping("private")
    public String helloWorldAdminPrivate(){
        return "Hello from private admin endpoint";
    }

}
