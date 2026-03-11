package com.abc.ecommerce.dto;

import lombok.Data;

@Data
public class ProductDto {

    private int productId;
    private String productName;
    private float price;
    private String description;

}
