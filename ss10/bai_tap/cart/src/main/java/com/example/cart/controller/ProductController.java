package com.example.cart.controller;


import com.example.cart.model.Cart;
import com.example.cart.model.Product;
import com.example.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/shop")
@SessionAttributes("cart")
public class ProductController {
    @ModelAttribute("cart")
    public Cart initCart() {
        return new Cart();
    }

    @Autowired
    IProductService productService;

    @GetMapping
    public ModelAndView showListPage() {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("productList",productService.findAll());
        return modelAndView;
    }

    @RequestMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/detail");
        modelAndView.addObject("product", productService.findById(id).get());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action) {
        System.out.println(action);
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Long id,
                         @ModelAttribute Cart cart,
                         @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error";
        }
        if (action.equals("show")) {
            cart.removeProduct(productOptional.get());
            return "redirect:/cart";
        }
        cart.removeProduct(productOptional.get());
        return "redirect:/shop";
    }
    @GetMapping("/pay")
    public String payment(@ModelAttribute Cart cart, RedirectAttributes redirectAttributes){
        float totalPayment = cart.countTotalPayment();
        cart.deleteAllItemInCard();
        redirectAttributes.addFlashAttribute("msg","Payment success with amount " +totalPayment);
        return "redirect:/cart";
    }
}
