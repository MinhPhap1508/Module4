package com.example.examination_4.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAll(String name, String price, Pageable pageable);
    Product findById(Integer id);
    void save(Product product);
    void update(Product product);
    void delete(Integer id);
}
