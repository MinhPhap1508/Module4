package com.example.cart.controller;


import com.example.cart.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {
    @ModelAttribute("cart")
    public Cart setUpCart(){
        return new Cart();
    }
    @GetMapping
    public ModelAndView showCart(@SessionAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }
}
