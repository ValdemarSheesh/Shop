package com.example.Shop.service.impl;

import com.example.Shop.exceptions.NotFoundException;
import com.example.Shop.model.OrderLine;
import com.example.Shop.repo.OrderLineRepository;
import com.example.Shop.service.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLineServiceImpl implements OrderLineService {

    @Autowired
    private OrderLineRepository orderLineRepository;

    @Override
    public OrderLine addOrderLine(OrderLine orderLine) {
        return orderLineRepository.saveAndFlush(orderLine);
    }

    @Override
    public OrderLine getOrderLineById(Long id) {
        return orderLineRepository.findById(id).orElseThrow(() -> new NotFoundException("Order line with id " + id + " not found"));
    }

    @Override
    public List<OrderLine> getAllOrderLine() {
        return orderLineRepository.findAll();
    }

    @Override
    public OrderLine editOrderLine(OrderLine orderLine) {
        getOrderLineById(orderLine.getId());
        return orderLineRepository.saveAndFlush(orderLine);
    }

    @Override
    public void deleteOrderLine(Long id) {
        orderLineRepository.delete(getOrderLineById(id));
    }
}
