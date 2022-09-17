package com.example.ssfminiproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ssfminiproject.Model.Food;
import com.example.ssfminiproject.Service.FoodService;

@RestController
public class FoodRestController {
    @Autowired
    FoodService service;

    @GetMapping("/file")
    public ResponseEntity<Food> getFood(Model model){
        // new Food() -> the specific food item retrieved from the database
        model.addAttribute("food", new Food());
        return new ResponseEntity<>(new Food(), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<String> getListOfFood(Model model) {
        FoodService foodService = new FoodService();
        model.addAttribute("list", attributeValue)
        return foodService.getListOfFood();
    }
}
