package com.example.app_blog.service;

import com.example.app_blog.model.Category;
import com.example.app_blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public List<Category> showCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> displayCategory(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void editCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category getById(int id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }
}
