package com.mikhi.hibernateAston.service.impl;



import com.mikhi.hibernateAston.controller.dto.CategoryDto;
import com.mikhi.hibernateAston.entity.Category;
import com.mikhi.hibernateAston.exceptions.ResourceNotFoundException;
import com.mikhi.hibernateAston.mapper.CategoriesMapper;
import com.mikhi.hibernateAston.repository.CategoryRepository;
import com.mikhi.hibernateAston.service.CategoriesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoriesServiceImpl implements CategoriesService {

    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

        Category category = CategoriesMapper.toEntity(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return CategoriesMapper.toDto(savedCategory);

    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found with id: " + id)
                );
        return CategoriesMapper.toDto(category);
    }

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map((category) -> CategoriesMapper.toDto(category))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto category) {

        Category updatedCategory = categoryRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Category not found with id: " + id)
        );

        updatedCategory.setName(category.getName());

        Category updatedCategoryObj = categoryRepository.save(updatedCategory);

        return CategoriesMapper.toDto(updatedCategoryObj);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Category not found with id: " + id)
        );

        categoryRepository.deleteById(id);

    }


}
