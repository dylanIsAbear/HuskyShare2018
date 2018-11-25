package com.example.demo.services;

import com.example.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.Map;

@Service
public class ValidationService {

    @Autowired
    RedisTemplate  redisTemplate;

    public void saveVCode(User user, int vcode){
        redisTemplate.opsForHash().put("ID_CODE", user.getId(), vcode);
    }

    public boolean checkVCode(User user, int vcode){
        return (int)redisTemplate.opsForHash().get("ID_CODE", user.getId()) == vcode;
    }

    public boolean checkVCode(int uid, int vcode){
        return (int)redisTemplate.opsForHash().get("ID_CODE", uid) == vcode;
    }

    public Map<Object, Object> getCodeMap(String entry, Map map){
        map = redisTemplate.opsForHash().entries(entry);
        return map;
    }

    public int generateVCode(){
        return (int)Math.random()*10000+10001;
    }

}
