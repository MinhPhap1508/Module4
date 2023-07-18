package com.example.demo.controller;

import com.example.demo.service.ICalculatorService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping("/")
    public String showCalculator(){
        return "/calculator";
    }

    @PostMapping("/calculate")
    public String showCalculator(@RequestParam double usd, @RequestParam double percent, Model model) {
      double result = calculatorService.calculator(usd, percent);
        model.addAttribute("result", result);
        return "/result";
    }

}
