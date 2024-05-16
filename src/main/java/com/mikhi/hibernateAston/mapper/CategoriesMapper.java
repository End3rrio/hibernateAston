package com.mikhi.hibernateAston.mapper;

import com.mikhi.hibernateAston.controller.dto.CategoryDto;
import com.mikhi.hibernateAston.entity.Category;

public class CategoriesMapper {
    public static CategoryDto toDto(Category category) {
        return new CategoryDto(
                category.getCategory_id(),
                category.getName()
        );
    }

    public static Category toEntity(CategoryDto categoryDto) {
        return new Category(
                categoryDto.getCategory_id(),
                categoryDto.getName()
        );
    }
}
