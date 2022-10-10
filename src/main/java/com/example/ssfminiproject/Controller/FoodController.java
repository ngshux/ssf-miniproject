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
        model.addAttribute("user", user);
        System.out.println(user);
        return "index";
    }

    @GetMapping(path="/login")
    public String loginPage(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping (path="/submitLogin")
    public String SubmitLogin(@ModelAttribute User user1, Model model) {
        model.addAttribute("user", user1);
        user.setName(user1.getName());
        user.setLoggedIn(true);
        return "redirect:/favourites";
    }

    @PostMapping (path="/logout")
    public String logout(Model model) {
        user.setLoggedIn(false);
        return "redirect:/";
    }

    @PostMapping (path="/addToFav")
    public String addToFav(@RequestParam String strMeal,
    @RequestParam String strMealThumb, @RequestParam String idMeal) {
        String recipeLink = "/recipe/"+idMeal;
        String redirect = user.isLoggedIn() == true ? "redirect:"+recipeLink : "redirect:/login";
        if(user.isLoggedIn()) {
            Meal meal = new Meal(strMeal, strMealThumb, idMeal);
            System.out.println("ADDING TO FAVOURITES" + meal);
            service.addRecipeToFavourite(user, meal);
        }
        return redirect;
    }

    @GetMapping("/favourites")
    public String favPage(Model model){
        model.addAttribute("user", user);
        if(user.isLoggedIn()) {
            model.addAttribute("favList", service.getFavourites(user));
            return "favourites";
        }
        return "login";
    }

    @PostMapping (path="/removeFavourite")
    public String removeFromFav(@RequestParam String strMeal,
                                @RequestParam String strMealThumb, @RequestParam String idMeal) {
        Meal meal = new Meal(strMeal, strMealThumb, idMeal);

        service.removeFromFavourite(user, meal);
        return "redirect:/favourites";
    }

    @GetMapping(path="/recipe/{recipeId}")
    public String recipePage(Model model, @PathVariable String recipeId){
        FoodService foodService = new FoodService();
        Recipe recipe = foodService.findById(recipeId);
        model.addAttribute("recipe", recipe);
        model.addAttribute("user", user);
        return "recipe";
    }

}
