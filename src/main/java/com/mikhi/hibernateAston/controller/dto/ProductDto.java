package com.mikhi.hibernateAston.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long product_id;
    private Long category_id;
    private String description;
    private String name;
    private Double price;
}
