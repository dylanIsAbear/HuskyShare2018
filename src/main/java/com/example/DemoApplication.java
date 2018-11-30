package com.example;
import com.example.demo.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration


@SpringBootApplication( scanBasePackages = "com.example.demo")
@EnableJpaAuditing
public class DemoApplication  extends SpringBootServletInitializer {
    @Autowired
    private static ValidationService validationService;
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


}