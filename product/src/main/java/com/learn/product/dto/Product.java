package com.learn.product.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int id;
    private String name;
    private Category category;
    private double price;
    private double discount;
    private String discountDescription;
}
