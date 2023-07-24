package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {


    @Override
    public double calculator(double money, double rate) {
        return money*rate;
    }
}
