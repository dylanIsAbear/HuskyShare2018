package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String args[]){
        ApplicationContext context = new AnnotationConfigApplicationContext(TextEditorConfig.class);
        TextEditor te = (TextEditor) context.getBean(TextEditor.class);
        te.setMessage("gg");
        te.getMessage();
    }
}
