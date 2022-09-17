package com.example.ssfminiproject.Service;

import com.example.ssfminiproject.Model.Food;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

// Service contains all the Redis Queries
// Rest controller will use the service to query the Redis database for data
public class FoodRedis implements FoodRepo{
    private static final Logger logger = LoggerFactory.getLogger(FoodRedis.class);

    @Autowired
    RedisTemplate<String, Food> template;

    @Override
    public void save(Food user) {
        template.opsForValue().set(user.getName(), user);
        logger.info("Saving article named >>>>> " + user.getName());
    }

    @Override
    public Food findById(String name) {
        Food user = (Food) template.opsForValue().get(name);
        return user;
    }
}
