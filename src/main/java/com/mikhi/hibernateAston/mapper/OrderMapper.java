package com.mikhi.hibernateAston.mapper;

import com.mikhi.hibernateAston.controller.dto.OrderDto;
import com.mikhi.hibernateAston.controller.dto.ProductDto;
import com.mikhi.hibernateAston.entity.Customer;
import com.mikhi.hibernateAston.entity.Order;
import com.mikhi.hibernateAston.entity.Product;

public class OrderMapper {
    public static OrderDto toDto(Order order) {
        return new OrderDto(
                order.getOrder_id(),
                order.getCustomer().getCustomer_id(),
                order.getOrder_date(),
                order.getOrder_status()
        );
    }

    public static Order toEntity(OrderDto orderDto) {
        Customer customer = new Customer();
        customer.setCustomer_id((orderDto.getCustomer_id()));
        return new Order(
                orderDto.getOrder_id(),
                customer,
                orderDto.getOrder_date(),
                orderDto.getOrder_status()
        );
    }
}


