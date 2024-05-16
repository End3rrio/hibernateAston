package com.mikhi.hibernateAston.service.impl;

import com.mikhi.hibernateAston.controller.dto.OrderDto;
import com.mikhi.hibernateAston.entity.Customer;
import com.mikhi.hibernateAston.entity.Order;
import com.mikhi.hibernateAston.exceptions.ResourceNotFoundException;
import com.mikhi.hibernateAston.mapper.OrderMapper;
import com.mikhi.hibernateAston.repository.CustomerRepository;
import com.mikhi.hibernateAston.repository.OrderRepository;
import com.mikhi.hibernateAston.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class OrderServiceImpl  implements OrderService {

    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;
    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = OrderMapper.toEntity(orderDto);
        Order savedOrder = orderRepository.save(order);
        return OrderMapper.toDto(savedOrder);
    }

    @Override
    public OrderDto getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Order not found with id " + id)
                );
        return OrderMapper.toDto(order);
    }

    @Override
    public List<OrderDto> getOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map((order) -> OrderMapper.toDto(order))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto updateOrder(Long id, OrderDto order) {
        Order updatedOrder = orderRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Order not found with id " + id)
        );

        Customer customer = customerRepository.findById(order.getCustomer_id()).orElseThrow(() ->
                new ResourceNotFoundException("Customer not found with id " + order.getCustomer_id())
        );

        updatedOrder.setCustomer(customer);
        updatedOrder.setOrder_date(order.getOrder_date());
        updatedOrder.setOrder_status(order.getOrder_status());

        Order updatedOrderObj = orderRepository.save(updatedOrder);

        return OrderMapper.toDto(updatedOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Order not found with id " + id)
        );
        orderRepository.delete(order);
    }
}
