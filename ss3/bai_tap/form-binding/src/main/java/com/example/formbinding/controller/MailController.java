package com.example.formbinding.controller;

import com.example.formbinding.model.Mail;
import com.example.formbinding.service.IMailService;
import com.example.formbinding.service.MailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MailController {
    private static IMailService mailService = new MailService();

    @ModelAttribute("languages")
    public String[] getLanguages(){
        return new String[]{"English","Vietnamese","Japanese","Chinese"};
    }
    @ModelAttribute("pageSize")
    public int[] getPage(){
        return new int[]{5,10,15,25,50,100};
    }
    @GetMapping("/info")
    public String showInfo(Model model) {
        model.addAttribute("info",mailService.getInfo());
        return "/info";
    }
    @GetMapping("/update")
    public String showSettings(Model model){
        model.addAttribute("setting", mailService.getInfo());
        return "/update";
    }
    @PostMapping("/update")
    public String setting(@ModelAttribute Mail mail, RedirectAttributes redirectAttributes){
        mailService.update(mail);
        redirectAttributes.addFlashAttribute("message", "save successful");
        return "redirect:/info";
    }
}
