package com.example.Shop.mapper;

import com.example.Shop.dto.GoodsDto;
import com.example.Shop.dto.OrderDto;
import com.example.Shop.dto.OrderLineDto;
import com.example.Shop.model.Goods;
import com.example.Shop.model.Order;
import com.example.Shop.model.OrderLine;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-05T21:51:29+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 19.0.2 (Oracle Corporation)"
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
    public OrderLine orderLineDtoToOrderLine(OrderLineDto orderLineDto) {
        if ( orderLineDto == null ) {
            return null;
        }

        OrderLine.OrderLineBuilder orderLine = OrderLine.builder();

        orderLine.id( orderLineDto.getId() );
        orderLine.order( orderDtoToOrder( orderLineDto.getOrder() ) );
        orderLine.goodsList( goodsDtoListToGoodsList( orderLineDto.getGoodsList() ) );
        orderLine.count( orderLineDto.getCount() );

        return orderLine.build();
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
        if ( order.getDate() != null ) {
            orderDto.setDate( DateTimeFormatter.ISO_LOCAL_DATE.format( order.getDate() ) );
        }
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

    protected Order orderDtoToOrder(OrderDto orderDto) {
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

    protected Goods goodsDtoToGoods(GoodsDto goodsDto) {
        if ( goodsDto == null ) {
            return null;
        }

        Goods.GoodsBuilder goods = Goods.builder();

        goods.id( goodsDto.getId() );
        goods.name( goodsDto.getName() );
        goods.price( goodsDto.getPrice() );

        return goods.build();
    }

    protected List<Goods> goodsDtoListToGoodsList(List<GoodsDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Goods> list1 = new ArrayList<Goods>( list.size() );
        for ( GoodsDto goodsDto : list ) {
            list1.add( goodsDtoToGoods( goodsDto ) );
        }

        return list1;
    }
}
