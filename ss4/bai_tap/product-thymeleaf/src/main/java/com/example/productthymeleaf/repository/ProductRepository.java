package com.example.productthymeleaf.repository;

import com.example.productthymeleaf.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> displayAll() {
        TypedQuery<Product> query = entityManager.createQuery("from Product ", Product.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void addProduct(Product product) {
        try {
            entityManager.persist(product);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    @Override

    public void updateProduct(int id, Product product) {
        Product product1 = getByID(id);
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setDescription(product.getDescription());
        product1.setProducer(product.getProducer());
        entityManager.merge(product1);
    }

    @Transactional
    @Override
    public void remove(int id) {
        Product product = getByID(id);
        if (product != null) {
            entityManager.remove(product);
        }
    }

    @Override
    public Product getByID(int id) {
        Product product = entityManager.find(Product.class, id);
        return product;
    }

    @Override
    public List<Product> search(String name) {
        List<Product> products = new ArrayList<>();
        TypedQuery<Product> query = entityManager.createQuery("from Product ", Product.class);
        List<Product> productList= query.getResultList();
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getName().contains(name)){
                products.add(productList.get(i));
            }
        }
        return products;
    }
}
