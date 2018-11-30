package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class GeneralController {
    @RequestMapping(value = "/")
    public String index(){
        return "Hello Spring";
    }
}
