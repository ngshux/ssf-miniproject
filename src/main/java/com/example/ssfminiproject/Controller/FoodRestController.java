package com.example.ssfminiproject.Controller;

import com.example.ssfminiproject.Model.Recipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ssfminiproject.Service.FoodService;

@RestController
@Service
@RequestMapping(produces="application/json")
public class FoodRestController {
    private static final Logger logger = LoggerFactory.getLogger(FoodRestController.class);

    @Autowired
    FoodService service;

    @GetMapping(path="/{recipeId}")
    public ResponseEntity<Recipe> getMealById(@PathVariable String recipeId) {
        Recipe recipe = service.findById(recipeId);
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }


}
