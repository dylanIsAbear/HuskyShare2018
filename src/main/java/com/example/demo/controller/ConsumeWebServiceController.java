package com.example.demo.controller;

import com.example.demo.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class ConsumeWebServiceController {
    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/templates/products")
    public String getProductLists(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        //在URL上执行特定的HTTP方法，返回包含对象的ResponseEntity，这个对象是从响应体中
        //映射得到的
        return restTemplate.exchange("http://localhost:8081/products",
                HttpMethod.GET, entity, String.class).getBody();
    }

    @RequestMapping(value = "/templates/products", method = RequestMethod.POST)
    public String createProducts(@RequestBody Product product){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<Product>(product, headers);
        return  restTemplate.exchange("http://localhost:8080/products", HttpMethod.POST,
                entity, String.class).getBody();
    }

}
