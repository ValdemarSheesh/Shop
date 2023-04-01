package com.example.Shop.controller;

import com.example.Shop.dto.OrderLineDto;
import com.example.Shop.exceptions.InvalidValueException;
import com.example.Shop.mapper.OrderLineMapper;
import com.example.Shop.model.OrderLine;
import com.example.Shop.service.impl.OrderLineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("orderLine")
public class OrderLineController {

    @Autowired
    private OrderLineServiceImpl orderLineService;

    @PostMapping
    public ResponseEntity<?> saveOrderLine(@Validated @RequestBody OrderLineDto orderLineDto,
                                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new InvalidValueException(InvalidValueException.createMessage(bindingResult));
        }

        OrderLine orderLine = OrderLineMapper.INSTANCE.orderLineDtoToOrderLine(orderLineDto);

        return ResponseEntity.ok(OrderLineMapper.INSTANCE.orderLineToOrderLineDto(orderLineService.addOrderLine(orderLine)));
    }

    @PutMapping
    public ResponseEntity<?> updateOrderLine(@Validated @RequestBody OrderLineDto orderLineDto,
                                             BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new InvalidValueException(InvalidValueException.createMessage(bindingResult));
        }

        OrderLine orderLine = OrderLineMapper.INSTANCE.orderLineDtoToOrderLine(orderLineDto);

        return ResponseEntity.ok(OrderLineMapper.INSTANCE.orderLineToOrderLineDto(orderLineService.editOrderLine(orderLine)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderLine(@PathVariable Long id) {
        OrderLine orderLine = orderLineService.getOrderLineById(id);
        return ResponseEntity.ok(OrderLineMapper.INSTANCE.orderLineToOrderLineDto(orderLine));
    }

    @GetMapping
    public ResponseEntity<?> getAllOrderLine() {
        List<OrderLine> orderLineList = orderLineService.getAllOrderLine();
        if (orderLineList.isEmpty())
            return ResponseEntity.ok("Orders is empty");
        else
            return ResponseEntity.ok(OrderLineMapper.INSTANCE.orderLineListToOrderLineDtoList(orderLineList));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteOrderLine(@RequestParam(value = "id") Long id) {
        orderLineService.deleteOrderLine(id);
        return ResponseEntity.ok("Orders deleted");
    }
}
