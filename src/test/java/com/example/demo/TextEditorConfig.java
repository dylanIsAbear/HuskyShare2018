package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*Annotating a class with the @Configuration indicates that the class can
    be used by the Spring IoC container as a source of bean definitions.*/
@Configuration
public class TextEditorConfig {
    @Bean
    public TextEditor TextEditor(){
        return new TextEditor();
    }

}
