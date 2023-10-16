package com.kh.product.svc;

import com.kh.product.dao.ProductDAO;
import com.kh.product.dao.entity.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductSVCImpl implements ProductSVC {

    private final ProductDAO productDAO;

    @Override
    public Long createProduct(Product product) {
        return productDAO.createProduct(product);
    }


    @Override
    public Optional<Product> readById(Long pid) {
        return productDAO.readById(pid);
    }

    @Override
    public int deleteProduct(Long pid) {
        return productDAO.deleteProduct(pid);
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public int updateProduct(Long pid, Product product) {
        return productDAO.updateProduct(pid, product);
    }
}
