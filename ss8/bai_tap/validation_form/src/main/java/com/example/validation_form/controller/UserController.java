package com.example.validation_form.controller;

import com.example.validation_form.model.User;
import com.example.validation_form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.annotation.UserConfigurations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "/form";
    }

    @PostMapping("/sign")
    public ModelAndView checkSign(@Validated @ModelAttribute User user, BindingResult bindingResult) {
        new User().validate(user, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/form");
        }
        userService.save(user);

        return new ModelAndView("/result");
    }
}
