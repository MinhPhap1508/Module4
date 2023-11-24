package com.example.examination_4.repository;

import com.example.examination_4.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from  Product where name like CONCAT('%', :name,'%') and price like CONCAT('%', :price,'%')",nativeQuery = true)
    Page<Product> finaAll(@Param("name") String name,
                          @Param("price") String price,
                          Pageable pageable);

    Optional<Product> findById(Integer id);
}
