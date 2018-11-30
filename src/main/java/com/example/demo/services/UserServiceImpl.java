package com.example.demo.services;

import com.example.demo.DTO.LoginForm;
import com.example.demo.Entity.User;
import com.example.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public String registry(User user){
        if(userDao.findByEmail(user.getEmail()) != null)   return "DUPLICATE_EMAIL";
        else if(userDao.findByName(user.getUsername()) != null){
            return "DUPLICATION_NAME";
        }
        user.setStatus(0);
        userDao.save(user);
        return "TO_VALIDATION";
    }

    public void updateUserStatus(int status, int uid){
        userDao.updateByStatus(status,uid);
    }

    @Override
    public User getUserById(int uid) {
        return userDao.findById(uid);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public Collection<User> getAllUser() {
        return userDao.findAll();
    }

    @Override
    public User createUser(LoginForm loginForm) {
        User user = new User();
        user.setEmail(loginForm.getEmail());
        user.setFirstName(loginForm.getFirstName());
        user.setLastName(loginForm.getLastName());
        user.setMobile(loginForm.getMobile());
        user.setUsername(loginForm.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(loginForm.getPassword()));
        user.setRole(loginForm.getRole());
        return userDao.save(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.findByName(username);
    }

    @Override
    public void deleteUserById(int uid) {
        userDao.delete(userDao.findById(uid));
    }
}
