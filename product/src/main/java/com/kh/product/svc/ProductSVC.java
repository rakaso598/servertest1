package com.kh.product.svc;

import com.kh.product.dao.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductSVC {

    // Create 상품등록
    Long createProduct(Product product);

    // Read 상품상세조회
    Optional<Product> readById(Long pid);

    // FindAll 전체목록조회
    List<Product> findAll();

    // Delete 상품삭제
    int deleteProduct(Long pid);


    // Update 상품수정
    int updateProduct(Long pid, Product product);
}
