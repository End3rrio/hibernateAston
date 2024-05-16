package com.mikhi.hibernateAston.service.impl;

import com.mikhi.hibernateAston.controller.dto.ProductDto;
import com.mikhi.hibernateAston.entity.Category;
import com.mikhi.hibernateAston.entity.Product;
import com.mikhi.hibernateAston.exceptions.ResourceNotFoundException;
import com.mikhi.hibernateAston.mapper.ProductMapper;
import com.mikhi.hibernateAston.repository.CategoryRepository;
import com.mikhi.hibernateAston.repository.ProductRepository;
import com.mikhi.hibernateAston.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = ProductMapper.toEntity(productDto);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.toDto(savedProduct);
    }

    @Override
    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Product not found with id " + id)
                );
        return ProductMapper.toDto(product);
    }

    @Override
    public List<ProductDto> getProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map((product) -> ProductMapper.toDto(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto product) {
        Product updatedProduct = productRepository.findById(id).orElseThrow(() ->

                new ResourceNotFoundException("Product not found with id " + id)
        );
        Category category = categoryRepository.findById(product.getCategory_id()).orElseThrow(() ->
                new ResourceNotFoundException("Category not found with id " + id)
        );

        updatedProduct.setCategory(category);
        updatedProduct.setDescription(product.getDescription());
        updatedProduct.setName(product.getName());
        updatedProduct.setPrice(product.getPrice());

        Product updatedProductObj = productRepository.save(updatedProduct);

        return ProductMapper.toDto(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Product not found with id " + id)
        );
        productRepository.deleteById(id);
    }
}
