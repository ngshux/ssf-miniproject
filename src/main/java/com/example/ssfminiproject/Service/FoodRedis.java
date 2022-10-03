package com.example.ssfminiproject.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


@Service
public class FoodRedis {
    private static final Logger logger = LoggerFactory.getLogger(FoodRedis.class);

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

}
