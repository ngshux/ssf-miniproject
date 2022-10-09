package com.example.ssfminiproject.Service;

import com.example.ssfminiproject.Model.Meal;
import com.example.ssfminiproject.Model.Recipe;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class FoodService {
    RestTemplate restTemplate = new RestTemplate();

    public String getListOfFood() {
        final String url = "https://www.themealdb.com/api/json/v1/1/filter.php?c=Seafood";
        return restTemplate.getForObject(url, String.class);
    }

    public List<Meal> getMeals() {
        final String url = "https://www.themealdb.com/api/json/v1/1/filter.php?c=Seafood";
        JsonObject jsonObject1 = Json.createReader(new ByteArrayInputStream(restTemplate.getForEntity(url, String.class).getBody().getBytes())).readObject();
        JsonArray jsonArray = jsonObject1.getJsonArray("meals");
        List<Meal> data = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            data.add(new Meal(jsonArray.getJsonObject(i).getString("strMeal"), jsonArray.getJsonObject(i).getString("strMealThumb"), jsonArray.getJsonObject(i).getString("idMeal")));
        }
        return data;
    }

    public Recipe findById(final String recipeId) {
        Recipe recipe = new Recipe();
        final String url = "https://www.themealdb.com/api/json/v1/1/lookup.php?i=" + recipeId;
        JsonObject jsonObject1 = Json.createReader(new ByteArrayInputStream(restTemplate.getForEntity(url, String.class).getBody().getBytes())).readObject();
        JsonArray jsonArray = jsonObject1.getJsonArray("meals");
        List<String> ingredientList = new ArrayList<>();
        List<String> measureList = new ArrayList<>();

        JsonObject l = jsonArray.getJsonObject(0);
        recipe.setStrMeal(l.get("strMeal").toString().substring(1, l.get("strMeal").toString().length() - 1));
        recipe.setStrMealThumb(l.get("strMealThumb").toString().substring(1, l.get("strMealThumb").toString().length() - 1));

        String[] instructions =(l.get("strInstructions").toString().substring(1, l.get("strInstructions").toString().length() - 1)).split("\\.");
        recipe.setInstructions(instructions);

        for (int j = 1; j < 21; j++) {
            String ingredientIndex = "strIngredient" + (j);
            String measureIndex = "strMeasure" + (j);
            if(!Objects.equals(l.get(ingredientIndex).toString(), "\"\"") && l.get(ingredientIndex).toString() != null){
                String ingredientItem = l.get(ingredientIndex).toString();
                String measureItem = l.get(measureIndex).toString();
                measureList.add(ingredientItem.substring(1, ingredientItem.length() - 1));
                ingredientList.add(measureItem.substring(1, measureItem.length() - 1));
            }
        }
        recipe.setIngredients(ingredientList);
        recipe.setMeasures(measureList);
        return recipe;
    }



}
