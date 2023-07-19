package com.example.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichController {
    @PostMapping("/sandwich")
    public ModelAndView save(@RequestParam(value = "condiments", required = false) String[] condiment) {
        ModelAndView modelAndView = new ModelAndView("/result");
        String message="";
        if(condiment == null || condiment.length ==0){

            modelAndView.addObject("message", "Không để trống sự lựa chọn của bạn");
        }
        modelAndView.addObject("result",condiment);
        return modelAndView;
    }

    @GetMapping()
    public String show() {
        return "/sandwich";
    }
}
