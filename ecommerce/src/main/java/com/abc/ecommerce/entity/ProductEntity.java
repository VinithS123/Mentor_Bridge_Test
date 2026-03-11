package com.abc.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ProductEntity {

    @Id
    private int productId;
    private String productName;
    private float price;
    private String description;

}
