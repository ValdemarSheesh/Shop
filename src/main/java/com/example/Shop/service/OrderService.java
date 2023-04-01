package com.example.Shop.service;

import com.example.Shop.model.Order;

import java.util.List;

public interface OrderService {

    Order addOrder(Order order);

    Order getOrderById(Long id);

    List<Order> getAllOrder();

    Order editOrder(Order order);

    void deleteOrder(Long id);
}
