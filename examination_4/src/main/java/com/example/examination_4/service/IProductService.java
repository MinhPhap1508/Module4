package com.example.examination_4.service;

import com.example.examination_4.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAll(String name, String price, Pageable pageable);
    Product findById(Integer id);
}
