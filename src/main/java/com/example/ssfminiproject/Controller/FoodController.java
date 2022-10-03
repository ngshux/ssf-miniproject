package com.example.ssfminiproject.Controller;

import com.example.ssfminiproject.Model.Recipe;
import com.example.ssfminiproject.Service.FoodRedis;
import com.example.ssfminiproject.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;

@Controller
public class FoodController {

    @Autowired
    FoodRedis service;


    @GetMapping("/")
    public String indexPage(Model model){
        FoodService foodService = new FoodService();
        model.addAttribute("meals", foodService.getMeals());
        return "index";
    }

    @GetMapping("/recipe/{recipeId}")
    public String recipePage(Model model, @PathVariable String recipeId){
        System.out.println(recipeId);
        FoodService foodService = new FoodService();
        Recipe recipe = foodService.findById(recipeId);
        model.addAttribute("recipe", recipe);
        return "recipe";
    }
}
