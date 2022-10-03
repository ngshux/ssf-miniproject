package com.example.ssfminiproject.Controller;

import com.example.ssfminiproject.Model.Recipe;
import com.example.ssfminiproject.Model.User;
import com.example.ssfminiproject.Service.FoodRedis;
import com.example.ssfminiproject.Service.FoodService;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping(path="/login")
    public String loginPage(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping (path="/login")
    public String loggedIn(@ModelAttribute("user") User user, Model model) {
        user.setName("hello");
        service.addUser(user);
        return "favourites";
    }

    @GetMapping(path="/recipe/{recipeId}")
    public String recipePage(Model model, @PathVariable String recipeId){
        System.out.println(recipeId);
        FoodService foodService = new FoodService();
        Recipe recipe = foodService.findById(recipeId);
        model.addAttribute("recipe", recipe);
        return "recipe";
    }
}
