package com.example.ssfminiproject.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class MealList {
    private ArrayList<Meal> meals;

    public MealList() {
        meals = new ArrayList<>();
    }

    public ArrayList<Meal> getMeals() {
        return meals;
    }

    @JsonProperty(value = "meals")
    public void setMeals(ArrayList<Meal> meals) {
        this.meals = meals;
    }
}
