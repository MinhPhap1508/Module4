package com.example.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
@GetMapping("/")
    public String showCalculator(){
    return "/home";
}
@PostMapping("/calculator")
    public ModelAndView calculator(@RequestParam double number1, @RequestParam double number2, String operator){
    double result=0;
    ModelAndView modelAndView = new ModelAndView("/home");
    switch (operator){
        case "+":
            result = number1 + number2;
            break;
        case "-":
            result = number1 - number2;
            break;
        case "*":
            result = number1 * number2;
            break;
        case "/":
            if(number2 == 0){
                return modelAndView.addObject("result", "Có lỗi xảy ra( Mẫu số phải khác không )");
            }else {
                result = number1 / number2;
            }
            break;
    }
    return modelAndView.addObject("result", result);
}
}
