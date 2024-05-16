package com.mikhi.hibernateAston.repository;


import com.mikhi.hibernateAston.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
