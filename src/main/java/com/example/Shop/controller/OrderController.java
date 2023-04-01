package com.example.Shop.controller;

import com.example.Shop.dto.OrderDto;
import com.example.Shop.exceptions.InvalidValueException;
import com.example.Shop.mapper.OrderMapper;
import com.example.Shop.model.Order;
import com.example.Shop.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping
    public ResponseEntity<?> saveOrder(@Validated @RequestBody OrderDto orderDto,
                                       BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new InvalidValueException(InvalidValueException.createMessage(bindingResult));
        }

        Order order = OrderMapper.INSTANCE.orderDtoToOrder(orderDto);

        return ResponseEntity.ok(OrderMapper.INSTANCE.orderToOrderDto(orderService.addOrder(order)));
    }

    @PutMapping
    public ResponseEntity<?> updateOrder(@Validated @RequestBody OrderDto orderDto,
                                         BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new InvalidValueException(InvalidValueException.createMessage(bindingResult));
        }

        Order order = OrderMapper.INSTANCE.orderDtoToOrder(orderDto);

        return ResponseEntity.ok(OrderMapper.INSTANCE.orderToOrderDto(orderService.editOrder(order)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrder(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        return ResponseEntity.ok(OrderMapper.INSTANCE.orderToOrderDto(order));
    }

    @GetMapping
    public ResponseEntity<?> getAllOrders() {
        List<Order> orders = orderService.getAllOrder();
        if (orders.isEmpty())
            return ResponseEntity.ok("Orders is empty");
        else
            return ResponseEntity.ok(OrderMapper.INSTANCE.ordersToOrderDtoList(orders));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteOrder(@RequestParam(value = "id") Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok("Orders deleted");
    }
}
