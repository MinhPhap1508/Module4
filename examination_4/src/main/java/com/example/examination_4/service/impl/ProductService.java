package com.example.examination_4.service.impl;

import com.example.examination_4.model.Product;
import com.example.examination_4.repository.IProductRepository;
import com.example.examination_4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public Page<Product> findAll(String name, String price, Pageable pageable) {
        return productRepository.finaAll(name,price,pageable);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).get();
    }
}
