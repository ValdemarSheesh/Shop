package com.example.Shop.mapper;

import com.example.Shop.dto.OrderDto;
import com.example.Shop.model.Order;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-31T19:53:29+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDto orderToOrderDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        orderDto.setId( order.getId() );
        orderDto.setClient( order.getClient() );
        orderDto.setDate( order.getDate() );
        orderDto.setAddress( order.getAddress() );

        return orderDto;
    }

    @Override
    public Order orderDtoToOrder(OrderDto orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( orderDto.getId() );
        order.setClient( orderDto.getClient() );
        order.setDate( orderDto.getDate() );
        order.setAddress( orderDto.getAddress() );

        return order;
    }

    @Override
    public List<OrderDto> ordersToOrderDtoList(List<Order> orders) {
        if ( orders == null ) {
            return null;
        }

        List<OrderDto> list = new ArrayList<OrderDto>( orders.size() );
        for ( Order order : orders ) {
            list.add( orderToOrderDto( order ) );
        }

        return list;
    }
}
