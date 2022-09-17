package com.example.ssfminiproject.Service;

import com.example.ssfminiproject.Model.Food;

public interface FoodRepo {
    public void save(Food food);

    public Food findById(final String id);
}
