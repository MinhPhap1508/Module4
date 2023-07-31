package com.example.cart.model;



import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> productMap = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> productMap) {
        this.productMap = productMap;
    }
    public void addProduct(Product product){
        if(productMap.containsKey(product)){
            Integer currentValue = productMap.get(product);
            productMap.replace(product,currentValue + 1);
        }else {
            productMap.put(product, 1);
        }
    }
    private boolean checkItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return entry;
            }
        }
        return null;
    }


    public Map<Product, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<Product, Integer> productMap) {
        this.productMap = productMap;
    }
    public void removeProduct(Product product) {
        Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
        Integer newQuantity = itemEntry.getValue() - 1;
        productMap.replace(itemEntry.getKey(), newQuantity);
    }

    public Integer countProductQuantity() {
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity() {
        return productMap.size();
    }

    public Float countTotalPayment() {
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }


    public void deleteAllItemInCard() {
        productMap.clear();
    }
}
