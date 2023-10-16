package com.kh.product.dao;

import com.kh.product.dao.entity.Product;

import java.util.Optional;

public interface ProductDAO {

    // Create
    Long createProduct(Product product);

    // Read 상세조회
    Optional<Product> readById(Long pid);


    // Delete
    Long deleteProduct(Long pid);

    // Update
}
