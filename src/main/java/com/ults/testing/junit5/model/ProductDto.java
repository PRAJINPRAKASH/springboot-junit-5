package com.ults.testing.junit5.model;

import lombok.Data;

@Data
public class ProductDto {
    
    private Long id;
    private String name;
    private double price;
    private String description;
    private Long quantity;
    private double totalPrice;
}
