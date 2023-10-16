package com.kh.product.svc;

import com.kh.product.dao.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductSVC {

    // Create
    Long createProduct(Product product);

    // Read
    Optional<Product> readById(Long pid);

    // findAll 전체목록조회
    List<Product> findAll();

    // Delete
    int deleteProduct(Long pid);


    // Update
    int updateProduct(Long pid, Product product);
}
