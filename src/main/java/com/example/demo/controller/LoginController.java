package com.example.demo.controller;

import com.example.demo.Entity.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(@RequestBody User user){
        return "LOGIN";
    }
}
