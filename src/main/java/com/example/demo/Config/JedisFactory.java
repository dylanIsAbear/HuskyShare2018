package com.example.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class JedisFactory {
    private static JedisFactory factory = new JedisFactory();
    Jedis jedis = null;

    public Jedis getJedis(){
        jedis = new Jedis("localhost", 6379);
        return jedis;
    }
    public JedisFactory(){

    }

    @Bean
    public JedisFactory getFactory(){
        return factory;
    }
}
