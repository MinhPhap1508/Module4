package com.example.app_blog.controller;

import com.example.app_blog.model.Blog;
import com.example.app_blog.model.Category;
import com.example.app_blog.service.IBlogService;
import com.example.app_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/category")
public class RestCategoryController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IBlogService blogService;
    @GetMapping
    public ResponseEntity<List<Category>> getList(){
        List<Category> categoryList = categoryService.showCategory();
        if(categoryList==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Blog>> show(@PathVariable int id){
        Category category = categoryService.getById(id);
        List<Blog> blogList = blogService.findByName(category.getName());
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }
}
