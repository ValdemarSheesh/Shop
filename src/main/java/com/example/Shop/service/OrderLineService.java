package com.example.Shop.service;

import com.example.Shop.model.OrderLine;

import java.util.List;

public interface OrderLineService {

    OrderLine addOrderLine(OrderLine orderLine);

    OrderLine getOrderLineById(Long id);

    List<OrderLine> getAllOrderLine();

    OrderLine editOrderLine(OrderLine orderLine);

    void deleteOrderLine(Long id);
}
