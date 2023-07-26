package com.example.app_blog.service;

import com.example.app_blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> showCategory();
    Page<Category> displayCategory(Pageable pageable);
    void addCategory(Category category);
    void editCategory(Category category);
    Category getById(int id);
    void deleteCategory(int id);
}
