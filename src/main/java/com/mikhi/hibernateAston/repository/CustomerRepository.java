package com.mikhi.hibernateAston.repository;

import com.mikhi.hibernateAston.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer, Long> {
}
