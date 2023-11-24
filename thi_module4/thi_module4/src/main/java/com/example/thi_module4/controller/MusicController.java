package com.example.thi_module4.controller;


import com.example.thi_module4.dto.MusicDto;
import com.example.thi_module4.model.Music;
import com.example.thi_module4.service.ICategoryService;
import com.example.thi_module4.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private IMusicService musicService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public String showList(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "") String name, Model model) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<Music> musicPage = musicService.findAll(pageable, name);
        model.addAttribute("musicPage", musicPage);
        model.addAttribute("category", categoryService.showCategory());
        return "/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes){
        musicService.deleteMusic(id);
        redirectAttributes.addFlashAttribute("msg", "Xóa thành công");
        return "redirect:/music";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("music", new Music());
        model.addAttribute("category", categoryService.showCategory());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@Valid @RequestParam MusicDto musicDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
        Music music = new Music();
        new MusicDto().validate(musicDto,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("musicDto", musicDto);
            model.addAttribute("category",categoryService.showCategory());
            return "/create";
        }
        BeanUtils.copyProperties(musicDto, music);
        musicService.addMusic(music);
        redirectAttributes.addFlashAttribute("msg","Thêm mới bài hát thành công");
        return "redirect:/music";
    }
}
