package com.example.Shop.mapper;

import com.example.Shop.dto.GoodsDto;
import com.example.Shop.dto.OrderDto;
import com.example.Shop.dto.OrderLineDto;
import com.example.Shop.model.Goods;
import com.example.Shop.model.Order;
import com.example.Shop.model.OrderLine;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-31T19:53:28+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
public class OrderLineMapperImpl implements OrderLineMapper {

    @Override
    public OrderLineDto orderLineToOrderLineDto(OrderLine orderLine) {
        if ( orderLine == null ) {
            return null;
        }

        OrderLineDto orderLineDto = new OrderLineDto();

        orderLineDto.setId( orderLine.getId() );
        orderLineDto.setOrder( orderToOrderDto( orderLine.getOrder() ) );
        orderLineDto.setGoodsList( goodsListToGoodsDtoList( orderLine.getGoodsList() ) );
        orderLineDto.setCount( orderLine.getCount() );

        return orderLineDto;
    }

    @Override
    public OrderLineDto orderLineDtoToOrderLine(OrderLineDto orderLineDto) {
        if ( orderLineDto == null ) {
            return null;
        }

        OrderLineDto orderLineDto1 = new OrderLineDto();

        orderLineDto1.setId( orderLineDto.getId() );
        orderLineDto1.setOrder( orderLineDto.getOrder() );
        List<GoodsDto> list = orderLineDto.getGoodsList();
        if ( list != null ) {
            orderLineDto1.setGoodsList( new ArrayList<GoodsDto>( list ) );
        }
        orderLineDto1.setCount( orderLineDto.getCount() );

        return orderLineDto1;
    }

    @Override
    public List<OrderLineDto> orderLineListToOrderLineDtoList(List<OrderLine> orderLineList) {
        if ( orderLineList == null ) {
            return null;
        }

        List<OrderLineDto> list = new ArrayList<OrderLineDto>( orderLineList.size() );
        for ( OrderLine orderLine : orderLineList ) {
            list.add( orderLineToOrderLineDto( orderLine ) );
        }

        return list;
    }

    protected OrderDto orderToOrderDto(Order order) {
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

    protected GoodsDto goodsToGoodsDto(Goods goods) {
        if ( goods == null ) {
            return null;
        }

        GoodsDto goodsDto = new GoodsDto();

        goodsDto.setId( goods.getId() );
        goodsDto.setName( goods.getName() );
        goodsDto.setPrice( goods.getPrice() );

        return goodsDto;
    }

    protected List<GoodsDto> goodsListToGoodsDtoList(List<Goods> list) {
        if ( list == null ) {
            return null;
        }

        List<GoodsDto> list1 = new ArrayList<GoodsDto>( list.size() );
        for ( Goods goods : list ) {
            list1.add( goodsToGoodsDto( goods ) );
        }

        return list1;
    }
}
