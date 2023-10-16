package com.kh.product.dao;

import com.kh.product.dao.entity.MyRowMapper;
import com.kh.product.dao.entity.Product;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Map;
import java.util.Optional;


@Data
@Slf4j
@SpringBootTest
public class ProductDAOImplTest {

    @Autowired  // 스프링 컨테이너에서 해당 타입의 객체를 주입받음.
    ProductDAO productDAO;

    //등록
    @Test
    @DisplayName("상품등록")
    void save(){
        Product product = new Product();
        product.setPid(1L);
        product.setPname("마우스");
        product.setQuantity(1L);
        product.setPrice(5000L);
        Long pid = productDAO.createProduct(product);
        log.info("상품아이디={}", pid);

        Assertions.assertThat(pid).isGreaterThan(0L);
    }


    // Read 상세조회
    @Test
    @DisplayName("상세조회")
    void readById(){
        Optional<Product> product = productDAO.readById(21L);
        Product findedProduct = product.orElseThrow();
        Assertions.assertThat(findedProduct.getPname()).isEqualTo("마우스");
        Assertions.assertThat(findedProduct.getQuantity()).isEqualTo(1L);
        Assertions.assertThat(findedProduct.getPrice()).isEqualTo(5000L);
    }



}
