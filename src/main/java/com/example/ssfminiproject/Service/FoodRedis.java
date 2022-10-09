package com.example.ssfminiproject.Service;

import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.ssfminiproject.Model.Meal;
import com.example.ssfminiproject.Model.User;

@Service
@Repository
public class FoodRedis implements FoodInterface{
    private static final Logger logger = LoggerFactory.getLogger(FoodRedis.class);

    @Resource(name="redisTemplate")     
    private HashOperations<String, String, String> hashOperations;

    @Resource(name="redisTemplate")     
    private SetOperations<String, Meal> setOperations;

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

    public void login(String username) {
        System.out.println("hello hohoho" + username);
    }

    @Override
    public boolean addUser(User user) {
        System.out.println("adding user:" + user.getName());
        hashOperations.putIfAbsent("user:" + user.getName(), "user", user.getName());
        return false;
    }

    @Override
    public boolean addRecipeToFavourite(User user, Meal meal) {
        //hash.putIfAbsent();
        return setOperations.add("user:shux", meal) == 1 ? true : false;
    }

    public List<Meal> getFavourites() {
        Meal meal = new Meal("hello", "hello", "hello");
        Set<Meal> favMeals = setOperations.members("user:shux");
        return new ArrayList<>(favMeals);
    }

    @Override
    public boolean checkFavourite(User user, int foodId) {
        // TODO Auto-generated method stub
        return false;
    }

}
