package com.example.thi_module4.service.impl;

import com.example.thi_module4.model.Category;
import com.example.thi_module4.repository.ICategoryRepository;
import com.example.thi_module4.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Category> showCategory() {
        return categoryRepository.findAll();
    }
}
