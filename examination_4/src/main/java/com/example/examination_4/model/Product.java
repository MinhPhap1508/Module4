package com.example.examination_4.model;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String price;
    private String mfg;
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    private ProductType productType;

    public Product() {
    }

    public Product(Integer id, String name, String price, String mfg, String description, ProductType productType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.mfg = mfg;
        this.description = description;
        this.productType = productType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMfg() {
        return mfg;
    }

    public void setMfg(String mfg) {
        this.mfg = mfg;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
