package com.example.ssfminiproject.Model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Food {
    private static final Logger logger = LoggerFactory.getLogger(Food.class);
   
    private String sentence;

    public static Food getFoodItems(String json) throws IOException{
        Food f = new Food();
        try (InputStream is = new ByteArrayInputStream(json.getBytes())){
            JsonReader r = Json.createReader(is);
            JsonArray arr = r.readArray();
            for (int i = 0; i < arr.size(); i++) {
                JsonObject l = arr.getJsonObject(i);
                f.sentence = l.get("q").toString();
            }
        }
        logger.info("Sentence: "+f.sentence);
        return f;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    
}

