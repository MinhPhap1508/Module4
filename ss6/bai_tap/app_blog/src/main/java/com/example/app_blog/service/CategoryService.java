package com.example.app_blog.service;

import com.example.app_blog.model.Category;
import com.example.app_blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    ICategoryRepository categoryRepository;
    @Override
    public List<Category> showCategory() {
        return categoryRepository.findAll();
    }
}
