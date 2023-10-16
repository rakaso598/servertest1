package com.kh.product.dao.entity;

import lombok.Data;

@Data
public class Product {
    private Long pid;
    private String pname;
    private Long quantity;
    private Long price;
}
