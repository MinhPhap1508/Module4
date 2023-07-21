package com.example.productthymeleaf.service;

import com.example.productthymeleaf.model.Product;
import com.example.productthymeleaf.repository.IProductRepository;
import com.example.productthymeleaf.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> displayAll() {
        return productRepository.displayAll();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    @Override
    public void updateProduct(int id, Product product) {
        productRepository.updateProduct(id, product);
    }

    @Override
    public void remove(int id) {
        productRepository.remove(id);
    }

    @Override
    public Product getByID(int id) {
        return productRepository.getByID(id);
    }

    @Override
    public List<Product> search(String name) {
        return productRepository.search(name);
    }
}
