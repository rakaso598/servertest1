package com.kh.product.dao;

import com.kh.product.dao.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDAO {

    // Create 상품등록
    Long createProduct(Product product);

    // FindAll 상품목록조회
    List<Product> findAll();
    
    // Read 상품상세조회
    Optional<Product> readById(Long pid);


    // Delete 상품삭제
    int deleteProduct(int pid);

    // Update 상품수정
    int updateProduct(Long pid, Product product);
}
