package com.example.demo.Utils;

import com.example.demo.DTO.LoginForm;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserCreateFormValidator implements Validator {
    private final UserService userService;

    @Autowired
    public  UserCreateFormValidator(UserService userService){
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(LoginForm.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        LoginForm userCreateForm = (LoginForm)o;
        validatePasswords(errors, userCreateForm);
        validateEmail(errors, userCreateForm);
        validateUsername(errors, userCreateForm);
    }

    private void validatePasswords(Errors errors,  LoginForm loginForm){
        if(loginForm.getPassword() != loginForm.getPasswordRepeated()){
            errors.reject("NOT_MATCHED_PASSWORD",  "The repeated password doesn't match ! ");
        }
    }

    private void validateEmail(Errors  errors, LoginForm loginForm){
        if(userService.getUserByEmail(loginForm.getEmail())!=null){
            errors.reject("DUPLICATE_EMAIL", "Email has been registered! ");
        }
    }

    private void validateUsername(Errors errors, LoginForm loginForm){
        if(userService.getUserByUsername(loginForm.getUsername()) != null){
            errors.reject("DUPLICATE_USERNAME", "Username has been registered! ");
        }
    }
}
