package com.mikhi.hibernateAston.service;


import com.mikhi.hibernateAston.controller.dto.CategoryDto;

import java.util.List;

public interface CategoriesService {
    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto getCategoryById(Long id);

    List<CategoryDto> getCategories();

    CategoryDto updateCategory(Long id, CategoryDto category);

    void deleteCategory(Long id);
}
