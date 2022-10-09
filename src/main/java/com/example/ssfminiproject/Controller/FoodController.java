package com.example.ssfminiproject.Controller;

import com.example.ssfminiproject.Model.Meal;
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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FoodController {

    @Autowired
    FoodRedis service;
    User user = new User();

    @GetMapping("/")
    public String indexPage(Model model){
        FoodService foodService = new FoodService();
        model.addAttribute("meals", foodService.getMeals());
        service.addRecipeToFavourite(user, foodService.getMeals().get(0));
        return "index";
    }

    @GetMapping(path="/login")
    public String loginPage(Model model){
        System.out.println("i am here");
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping (path="/login")
    public String SubmitLogin(@RequestParam String name, Model model) {
        user.setName(name);
        service.addUser(user);
        user.setLoggedIn(true);
        model.addAttribute(user);
        return "favourites";
    }

    @PostMapping (path="/addToFav")
    public String addToFav(@ModelAttribute("user") User user, @RequestParam String strMeal,
    @RequestParam String strMealThumb, @RequestParam String idMeal) {
        Meal meal = new Meal(strMeal, strMealThumb, idMeal);
        System.out.println("ADDING TO FAVOURITES" + meal);
        service.addRecipeToFavourite(user, meal);
        return "redirect:/favourites";
    }

    @GetMapping("/favourites")
    public String favPage(Model model){
        System.out.println(service.getFavourites());
        model.addAttribute("favList", service.getFavourites());
        return "favourites";
    }

    @GetMapping(path="/recipe/{recipeId}")
    public String recipePage(Model model, @PathVariable String recipeId){
        FoodService foodService = new FoodService();
        Recipe recipe = foodService.findById(recipeId);
        model.addAttribute("recipe", recipe);
        return "recipe";
    }

}
