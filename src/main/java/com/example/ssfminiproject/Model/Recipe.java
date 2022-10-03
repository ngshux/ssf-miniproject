package com.example.ssfminiproject.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

public class Recipe {
    @JsonProperty
    private String strMeal;
    @JsonProperty
    private String strMealThumb;
    @JsonProperty
    private String idMeal;
    @JsonProperty
    private String strCategory;
    @JsonProperty
    private String strArea;
    @JsonProperty
    private String strYoutube;

    private List<String> ingredients;
    private List<String> measures;
    private String[] instructions;


    public Recipe() {
    }

    public Recipe(String strMeal, String strMealThumb, String idMeal,
                  List<String> ingredients, List<String> measures, String[] instructions) {
        this.strMeal = strMeal;
        this.strMealThumb = strMealThumb;
        this.idMeal = idMeal;
        this.ingredients = ingredients;
        this.measures = measures;
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "strMeal='" + strMeal + '\'' +
                ", strMealThumb='" + strMealThumb + '\'' +
                ", idMeal='" + idMeal + '\'' +
                ", strCategory='" + strCategory + '\'' +
                ", strArea='" + strArea + '\'' +
                ", strYoutube='" + strYoutube + '\'' +
                ", ingredients=" + ingredients +
                ", measures=" + measures +
                '}';
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

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrArea() {
        return strArea;
    }

    public void setStrArea(String strArea) {
        this.strArea = strArea;
    }

    public String getStrYoutube() {
        return strYoutube;
    }

    public void setStrYoutube(String strYoutube) {
        this.strYoutube = strYoutube;
    }

    public static <T> void inspect(Class<T> recipe) {
        Field[] fields = recipe.getDeclaredFields();
        System.out.printf("%d fields:%n", fields.length);
        for (Field field : fields) {
            System.out.printf("%s %s %s%n",
                    Modifier.toString(field.getModifiers()),
                    field.getType().getSimpleName(),
                    field.getName()
            );
        }
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public List<String> getMeasures() {
        return measures;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setMeasures(List<String> measures) {
        this.measures = measures;
    }

    public String[] getInstructions() {
        return instructions;
    }

    public void setInstructions(String[] instructions) {
        this.instructions = instructions;
    }
}
