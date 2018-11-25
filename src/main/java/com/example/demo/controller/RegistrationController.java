package com.example.demo.controller;

import com.example.demo.Entity.User;
import com.example.demo.services.UserService;
import com.example.demo.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RegistrationController {
    @Autowired
    UserService userService;
    @Autowired
    ValidationService validationService;

    @RequestMapping(value = "/registry", method = RequestMethod.POST)
    public String registry(@RequestBody User user){
        return userService.registry(user);
    }

    @RequestMapping(value = "/registry/validation/{id}", method = RequestMethod.POST)
    public boolean validate(@RequestParam("vcode") int vcode,
                           @PathVariable("id") int uid){
        return validationService.checkVCode(uid,  vcode);
    }

    @RequestMapping(value = "/registry/validation", method = RequestMethod.GET)
    public String validEmail(@RequestParam("email") String email){

        return "EMAIL_SEND";
    }
}
