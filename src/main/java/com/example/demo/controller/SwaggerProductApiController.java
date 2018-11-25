package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SwaggerProductApiController {
    @RequestMapping(value = "/swagger/products", method = RequestMethod.GET)
    public List<String> getProducts() {
        List<String> productLists = new ArrayList<>();
        productLists.add("iPhone");
        productLists.add("iPad");
        productLists.add("MacBook");
        return productLists;
    }
}
