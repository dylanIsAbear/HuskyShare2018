package com.example.demo.services;

import com.example.demo.DTO.LoginForm;
import com.example.demo.Entity.User;

import java.util.Collection;
import java.util.List;

public interface UserService  {
    User getUserById(int uid);

    User getUserByEmail(String email);

    Collection<User> getAllUser();

    User createUser(LoginForm loginForm);

    void deleteUserById(int uid);

    User getUserByUsername(String username);

}
