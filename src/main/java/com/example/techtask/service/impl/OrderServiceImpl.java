package com.example.techtask.service.impl;

import com.example.techtask.data.repository.OrderRepository;
import com.example.techtask.model.Order;
import com.example.techtask.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order findOrder() {
        Optional<Order> optionalOrder = orderRepository.findLastWithMoreThanOneProduct();
        return optionalOrder.orElseThrow(()->new RuntimeException("Not found order with more than one product"));
    }

    @Override
    public List<Order> findOrders() {
        return orderRepository.findByActiveUsersOrderByDate();
    }
}
