package com.mikhi.hibernateAston.service;

import com.mikhi.hibernateAston.controller.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto product);

    ProductDto getProductById(Long id);

    List<ProductDto> getProducts();

    ProductDto updateProduct(Long id, ProductDto product);

    void deleteProduct(Long id);
}
