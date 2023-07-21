package com.example.productthymeleaf.repository;

import com.example.productthymeleaf.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Xiaomi", 999999, "Mi 12 Ultra", "China"));
        productList.add(new Product(2, "Apple", 7777777, "Iphone 12", "USA"));
        productList.add(new Product(3, "SamSung", 666666, "SamSung Galaxy Z Fold 4", "Korea"));
    }

    @Override
    public List<Product> displayAll() {
        return productList;
    }

    @Override
    public void addProduct(Product product) {
        productList.add(product);
    }

    @Override
    public void updateProduct(int id, Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.set(i,product);
            }
        }
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.remove(i);
            }
        }
    }

    @Override
    public Product getByID(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getId()==id){
                return productList.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Product> search(String name) {
        List<Product> products = new ArrayList<>();
        for (Product p: productList) {
            if(p.getName().contains(name))
                products.add(p);
        }
        return products;
    }
}
