package com.example.app_blog.controller;

import com.example.app_blog.model.Blog;
import com.example.app_blog.model.Category;
import com.example.app_blog.service.IBlogService;
import com.example.app_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;
    @Autowired
    IBlogService blogService;

    @GetMapping
    public ModelAndView showCategory(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<Category> categoryPage = categoryService.displayCategory(pageable);
        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("categoryPage", categoryPage);
        return modelAndView;
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("category", new Category());
        return "/category/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.addCategory(category);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/category";
    }

    @GetMapping("/edit")
    public String editBlog(@RequestParam int id, Model model) {
        Category category = categoryService.getById(id);
        model.addAttribute("category", category);
        return "/category/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.editCategory(category);
        redirectAttributes.addFlashAttribute("msg", "Cập nhật danh mục thành công");
        return "redirect:/category";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        categoryService.deleteCategory(id);
        redirectAttributes.addFlashAttribute("msg", "Xóa thành công");
        return "redirect:/category";
    }

    @GetMapping("/info/{id}")
    public String info(@PathVariable int id, Model model) {
//        List<Blog> blogs = blogService.blogList(id);
//        model.addAttribute("blogPages", blogService.blogList(id));
        Category category = categoryService.getById(id);
        model.addAttribute("category", category);
        return "/category/info";
    }
}
