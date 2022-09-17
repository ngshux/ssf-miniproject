package com.example.ssfminiproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.StringReader;
import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepo;

    public Integer count() {
        return foodRepo.count();
    }

    public List<String> keys() {
        return foodRepo.keys();
    }

    public Optional<Boardgame> getBoardgameById(Integer id) {
        return getBoardgameById(id.toString());
    }
    public Optional<Boardgame> getBoardgameById(String id) {
        String result = foodRepo.get(id);
        if (null == result)
            return Optional.empty();

        return Optional.of(Boardgame.create(result));
    }
}
