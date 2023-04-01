package com.example.Shop.service.impl;

import com.example.Shop.exceptions.NotFoundException;
import com.example.Shop.model.Order;
import com.example.Shop.repo.OrderRepository;
import com.example.Shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order addOrder(Order order) {
        return orderRepository.saveAndFlush(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new NotFoundException("Order with id " + id + " not found"));
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Order editOrder(Order order) {
        getOrderById(order.getId());
        return orderRepository.saveAndFlush(order);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.delete(getOrderById(id));
    }
}
