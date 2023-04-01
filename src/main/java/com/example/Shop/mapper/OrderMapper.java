package com.example.Shop.mapper;

import com.example.Shop.dto.OrderDto;
import com.example.Shop.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDto orderToOrderDto(Order order);

    Order orderDtoToOrder(OrderDto orderDto);

    List<OrderDto> ordersToOrderDtoList(List<Order> orders);
}
