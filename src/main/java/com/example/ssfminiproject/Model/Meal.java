package com.example.ssfminiproject.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public class Meal implements Serializable {
    @JsonProperty
    private String strMeal;
    @JsonProperty
    private String strMealThumb;
    @JsonProperty
    private String idMeal;

    public Meal(String strMeal, String strMealThumb, String idMeal) {
        this.strMeal = strMeal;
        this.strMealThumb = strMealThumb;
        this.idMeal = idMeal;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    public String getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(String idMeal) {
        this.idMeal = idMeal;
    }

    @JsonValue
    public String toJson() {
        return "{" +
                "\"strMeal\":\"" + strMeal + '\"' +
                ", \"strMealThumb\":\"" + strMealThumb + '\"' +
                ", \"idMeal\":\"" + idMeal + '\"' +
                '}';
    }

    public String toString() {
        return "Meal: " + strMeal + " Meal Thumb: " + strMealThumb + " Meal ID: " + idMeal;
    }
}
