package com.example.ssfminiproject.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.example.ssfminiproject.Model.Food;

@Service
public class FoodService {

    public ResponseEntity<String> getListOfFood() {
        final String url = "https://www.themealdb.com/api/json/v1/1/filter.php?c=Seafood";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
