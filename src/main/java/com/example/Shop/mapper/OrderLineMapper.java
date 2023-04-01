package com.example.Shop.mapper;

import com.example.Shop.dto.OrderLineDto;
import com.example.Shop.model.OrderLine;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderLineMapper {

    OrderLineMapper INSTANCE = Mappers.getMapper(OrderLineMapper.class);

    OrderLineDto orderLineToOrderLineDto(OrderLine orderLine);

    OrderLine orderLineDtoToOrderLine(OrderLineDto orderLineDto);

    List<OrderLineDto> orderLineListToOrderLineDtoList(List<OrderLine> orderLineList);
}
