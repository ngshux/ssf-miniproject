package com.example.ssfminiproject.Service;

import java.util.Map;

import com.example.ssfminiproject.Model.Meal;
import com.example.ssfminiproject.Model.User;

public interface FoodInterface {
    //Check if it is inside this particular user's favourite list
    boolean checkFavourite(User user, int foodId);
    //Add this recipe to the user's favourite list
    boolean addRecipeToFavourite(User user, Meal meal);
    boolean addUser(User user);
}
