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
public class FoodRedis {
    private static final Logger logger = LoggerFactory.getLogger(FoodRedis.class);

    @Resource(name="redisTemplate")     
    private HashOperations<String, String, String> hashOperations;

    @Resource(name="redisTemplate")     
    private SetOperations<String, Meal> setOperations;

    public void login(String username) {
    }

    public boolean addRecipeToFavourite(User user, Meal meal) {
        System.out.println(meal);
        //hash.putIfAbsent();
        return setOperations.add("user:" + user.getName(), meal) == 1 ? true : false;
    }

    public boolean removeFromFavourite(User user, Meal meal) {
        return setOperations.remove("user:" + user.getName(), meal) == 1 ? true : false;
    }

    public List<Meal> getFavourites(User user) {
        Set<Meal> favMeals = setOperations.members("user:" + user.getName());
        return new ArrayList<>(favMeals);
    }

}
