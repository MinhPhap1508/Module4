package com.example.dictionaryspring.service;

import com.example.dictionaryspring.repository.IDicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DicService implements IDicService{
    @Autowired
    private IDicRepository dicRepository;
    @Override
    public String translate(String word) {
        String translate = dicRepository.translate(word);
        if(translate != null){
            return translate;
        }
        return "No Result";
    }
}
