package com.example.productthymeleaf.repository;

import com.example.productthymeleaf.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> displayAll();
    void addProduct(Product product);

    void updateProduct(int id, Product product);
    void remove(int id);
    Product getByID(int id);
    List<Product> search(String name);
}
