package com.example.examination_4.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameCategory;

    @OneToMany(mappedBy = "productType")
    private Set<Product> productSet;

    public ProductType() {
    }

    public ProductType(Integer id, String nameCategory, Set<Product> productSet) {
        this.id = id;
        this.nameCategory = nameCategory;
        this.productSet = productSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }
}
