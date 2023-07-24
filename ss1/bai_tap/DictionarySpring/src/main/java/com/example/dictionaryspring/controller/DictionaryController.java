package com.example.dictionaryspring.controller;

import com.example.dictionaryspring.service.IDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDicService dicService;
    @GetMapping("/")
    public String showDictionary(){
        return "/translateForm";
    }
    @PostMapping("/translator")
    public String translate(@RequestParam String word, Model model){
        String result = dicService.translate(word);
        model.addAttribute("result", result);
        return "/translateForm";
    }
}
