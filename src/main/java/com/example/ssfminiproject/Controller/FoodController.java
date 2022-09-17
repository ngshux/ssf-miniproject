package com.example.ssfminiproject.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ssfminiproject.Model.Food;

@Controller
public class FoodController {

    @GetMapping("/")
    public String indexPage(Model model){
        model.addAttribute("food", new Food());
        return "index";
    }


}
