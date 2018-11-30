package com.example.demo.services;

import com.example.demo.Config.JedisFactory;
import com.example.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Map;

@Component
@Service
public class ValidationService {

    @Autowired
    JedisFactory jedisFactory;

    public String saveVCode(User user, int vcode){
        Jedis jedis = jedisFactory.getJedis();
        jedis.setex(""+user.getId(),1200, ""+vcode);
        jedis.close();
        return ""+vcode;
    }

    public boolean checkVCode(User user, int vcode){
        Jedis jedis = jedisFactory.getJedis();
        return jedis.get(""+user.getId()).equals(""+vcode);
    }

    public String testVCode(int uid){
        Jedis jedis = jedisFactory.getJedis();
        System.out.println(jedis.get(""+uid));
        return jedis.get(""+uid);
    }

    public boolean checkVCode(int uid, int vcode){
        Jedis jedis = jedisFactory.getJedis();
        System.out.println(jedis.get(""+uid));
        return jedis.get(""+uid).equals(""+vcode);
    }

    public int generateVCode(){
        return (int)(Math.random()*10000+10001);
    }

}
