package com.example.Shop.mapper;

import com.example.Shop.dto.OrderDto;
import com.example.Shop.model.Order;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-05T21:51:29+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 19.0.2 (Oracle Corporation)"
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
        if ( order.getDate() != null ) {
            orderDto.setDate( DateTimeFormatter.ISO_LOCAL_DATE.format( order.getDate() ) );
        }
        orderDto.setAddress( order.getAddress() );

        return orderDto;
    }

    @Override
    public Order orderDtoToOrder(OrderDto orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        Order.OrderBuilder order = Order.builder();

        order.id( orderDto.getId() );
        order.client( orderDto.getClient() );
        order.date( orderDto.getDate() );
        order.address( orderDto.getAddress() );

        return order.build();
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
