package com.example.ssfminiproject.Service;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.ssfminiproject.Model.Meal;
import com.example.ssfminiproject.Model.User;

@Service
@Repository
public class FoodRedis implements FoodInterface{
    private static final Logger logger = LoggerFactory.getLogger(FoodRedis.class);
    private HashOperations<String, String, User> hash;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public Map<Integer, User> getAllUsers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User getUser(String username) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean addUser(User user) {
        hash.putIfAbsent("user:" + user.getName(), "user", user);
        return false;
    }

    @Override
    public boolean addRecipeToFavourite(User user, Meal meal) {
        //hash.putIfAbsent();
        return redisTemplate.opsForSet().add("user:" + user.getName(), meal.getIdMeal()) == 1 ? true : false;
    }

    @Override
    public boolean checkFavourite(User user, int foodId) {
        // TODO Auto-generated method stub
        return false;
    }

}
