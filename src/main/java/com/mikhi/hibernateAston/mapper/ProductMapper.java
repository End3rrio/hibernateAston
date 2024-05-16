package com.mikhi.hibernateAston.mapper;

import com.mikhi.hibernateAston.controller.dto.ProductDto;
import com.mikhi.hibernateAston.entity.Category;
import com.mikhi.hibernateAston.entity.Product;

public class ProductMapper {
    public static ProductDto toDto(Product product) {
        return new ProductDto(
                product.getProduct_id(),
                product.getCategory().getCategory_id(),
                product.getDescription(),
                product.getName(),
                product.getPrice()
        );
    }

    public static Product toEntity(ProductDto productDto) {
        Category category = new Category();
        category.setCategory_id(productDto.getCategory_id());
        return new Product(
                productDto.getProduct_id(),
                category,
                productDto.getDescription(),
                productDto.getName(),
                productDto.getPrice()
        );
    }

}
