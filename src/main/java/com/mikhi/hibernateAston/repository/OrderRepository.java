package com.mikhi.hibernateAston.repository;

import com.mikhi.hibernateAston.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
