package com.mikhi.hibernateAston.service;

import com.mikhi.hibernateAston.controller.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto createOrder(OrderDto order);

    OrderDto getOrderById(Long id);

    List<OrderDto> getOrders();

    OrderDto updateOrder(Long id, OrderDto order);

    void deleteOrder(Long id);
}
