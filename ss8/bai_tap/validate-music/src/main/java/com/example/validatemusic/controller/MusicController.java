package com.example.validatemusic.controller;

import com.example.validatemusic.dto.MusicDto;
import com.example.validatemusic.model.Music;
import com.example.validatemusic.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    IMusicService musicService;

    @GetMapping
    public ModelAndView listMusic() {
        ModelAndView modelAndView = new ModelAndView("/list");
        List<Music> musicList = musicService.showMusic();
        modelAndView.addObject("list", musicList);
        return modelAndView;
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        MusicDto musicDto = new MusicDto();
        model.addAttribute("musicDto", new Music());
        return "/create";
    }

    @PostMapping("/create")
    public String upload(@Valid @ModelAttribute MusicDto musicDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        Music music = new Music();
        new MusicDto().validate(musicDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        BeanUtils.copyProperties(musicDto, music);
        musicService.upload(music);
        redirectAttributes.addFlashAttribute("msg", "upload complete");
        return "redirect:/music";
    }

    @GetMapping("/update")
    public String showFormUpdate(@PathVariable int id, Model model) {
        Music music = musicService.getById(id);
        MusicDto musicDto = new MusicDto();
        BeanUtils.copyProperties(music,musicDto);
        model.addAttribute("musicDto", musicDto);
        return "/update";
    }
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute MusicDto musicDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes){
        new MusicDto().validate(musicDto,bindingResult);
        if(bindingResult.hasErrors()){
            return "/update";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        musicService.edit(music);
        redirectAttributes.addFlashAttribute("msg", "Upload complete");
        return "redirect:/music";
    }
}
