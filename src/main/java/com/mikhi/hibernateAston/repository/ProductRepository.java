package com.mikhi.hibernateAston.repository;

import com.mikhi.hibernateAston.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
