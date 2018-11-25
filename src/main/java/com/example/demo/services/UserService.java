package com.example.demo.services;

import com.example.demo.Entity.User;
import com.example.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;

@Service
public class UserService  {
    @Autowired
    UserDao userDao;

    public void saveUser(User user){
        userDao.save(user);
    }

    public User findUser(int uid){
        return userDao.findById(uid);
    }

    public int getUserID(){
        int id = 10000+(int)userDao.count();
        return id;
    }

    public List<User> findAllUser(){
        return userDao.findAll();
    }

    public String registry(User user){
        if(userDao.findByEmail(user.getEmail()) != null)   return "DUPLICATE_EMAIL";
        else if(userDao.findByName(user.getUsername()) != null){
            return "DUPLICATION_NAME";
        }
        user.setStatus(0);
        userDao.save(user);
        return "TO_VALIDATION";
    }

}
