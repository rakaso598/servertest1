package com.kh.product.dao;

import com.kh.product.dao.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDAO {

    // Create
    Long createProduct(Product product);

    // findAll 목록조회
    List<Product> findAll();
    
    // Read 상세조회
    Optional<Product> readById(Long pid);


    // Delete
    int deleteProduct(Long pid);

    // Update
    int updateProduct(Long pid, Product product);
}
