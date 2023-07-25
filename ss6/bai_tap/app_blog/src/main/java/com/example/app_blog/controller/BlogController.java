package com.example.app_blog.controller;

import com.example.app_blog.model.Blog;
import com.example.app_blog.model.Category;
import com.example.app_blog.service.IBlogService;
import com.example.app_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public String showList(Model model) {
        List<Blog> blogList = blogService.showList();
        model.addAttribute("blog", blogList);
        return "/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("category", categoryService.showCategory());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog) {
        blogService.addBlog(blog);
        return "redirect:/blog";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int id){
        blogService.delete(id);
        return "redirect:/blog";
    }
}
