package com.example.examination_4.repository;

import com.example.examination_4.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductTypeRepository extends JpaRepository<ProductType, Integer> {
}
