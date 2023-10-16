package com.kh.product.svc;

import com.kh.product.dao.entity.Product;

import java.util.Optional;

public interface ProductSVC {

    // Create
    Long createProduct(Product product);

    // Read
    Optional<Product> readById(Long pid);


    // Delete
    Long deleteProduct(Long pid);


    // Update
}
