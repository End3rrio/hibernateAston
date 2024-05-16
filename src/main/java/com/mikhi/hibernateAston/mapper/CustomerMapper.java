package com.mikhi.hibernateAston.mapper;

import com.mikhi.hibernateAston.controller.dto.CustomerDto;
import com.mikhi.hibernateAston.entity.Customer;

public class CustomerMapper {
    public static CustomerDto toDto(Customer customer) {
        return new CustomerDto(
                customer.getCustomer_id(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail()
        );
    }

    public static Customer toEntity(CustomerDto customerDto) {
        return new Customer(
                customerDto.getCustomer_id(),
                customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getEmail()
        );
    }
}
