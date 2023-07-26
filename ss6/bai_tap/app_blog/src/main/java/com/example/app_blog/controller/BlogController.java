package com.example.app_blog.controller;

import com.example.app_blog.model.Blog;
import com.example.app_blog.model.Category;
import com.example.app_blog.service.IBlogService;
import com.example.app_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

//    @GetMapping
//    public String showList(Model model) {
//        List<Blog> blogList = blogService.showList();
//        model.addAttribute("blog", blogList);
//        return "/list";
//    }
    @GetMapping
    public ModelAndView showList(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "") String searchName){
        Pageable pageable = PageRequest.of(page, 2, Sort.by("date").descending());
        Page<Blog> blogPage = blogService.findAll(pageable,searchName);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("blogPage", blogPage);
        return modelAndView;
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("category", categoryService.showCategory());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.addBlog(blog);
        redirectAttributes.addFlashAttribute("msg", "Đã đăng blog");
        return "redirect:/blog";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "Xóa thành công");
        return "redirect:/blog";
    }

    @GetMapping("/info/{id}")
    public String info(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.getById(id));
        return "/info";
    }

    @GetMapping("/edit")
    public String editBlog(@RequestParam int id, Model model) {
        Blog blog = blogService.getById(id);
        model.addAttribute("categoryList", categoryService.showCategory());
        model.addAttribute("blog", blog);
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.edit(blog);
        redirectAttributes.addFlashAttribute("msg", "Cập nhật blog thành công");
        return "redirect:/blog";
    }
}
