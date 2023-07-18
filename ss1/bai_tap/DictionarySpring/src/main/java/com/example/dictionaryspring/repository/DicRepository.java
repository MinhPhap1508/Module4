package com.example.dictionaryspring.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class DicRepository implements  IDicRepository{
    private static Map<String, String> stringMap = new HashMap<>();

    static {
        stringMap.put("pen", "Cây bút");
        stringMap.put("car", "Xe hơi");
        stringMap.put("tree", "Cái cây");
        stringMap.put("house", "Ngôi nhà");
        stringMap.put("apple", "Quả Táo");
    }
    @Override
    public String translate(String words) {
        return stringMap.get(words);
    }
}
