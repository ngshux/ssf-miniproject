package com.example.ssfminiproject.Model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Food {
    private static final Logger logger = LoggerFactory.getLogger(Food.class);

    private String name;
    private String description;
    private int qty;

    

    public Food() {
        this.name = "Chicken";
        this.description = "I like chicken";
        this.qty = 1;
    }

    public Food(String name, String description, int qty) {
        this.name = name;
        this.description = description;
        this.qty = qty;
    }

    public static Food getFoodItems(String json) throws IOException {
        Food f = new Food();
        try (InputStream is = new ByteArrayInputStream(json.getBytes())) {
            JsonReader r = Json.createReader(is);
            JsonArray arr = r.readArray();
            for (int i = 0; i < arr.size(); i++) {
                JsonObject l = arr.getJsonObject(i);
                f.name = l.get("q").toString();
            }
        }
        logger.info("Sentence: " + f.name);
        return f;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Name:" + name;
    }
    

}
