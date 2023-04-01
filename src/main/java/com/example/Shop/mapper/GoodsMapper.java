package com.example.Shop.mapper;

import com.example.Shop.dto.GoodsDto;
import com.example.Shop.model.Goods;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GoodsMapper {

    GoodsMapper INSTANCE = Mappers.getMapper(GoodsMapper.class);

    GoodsDto goodsToGoodsDto(Goods goods);

    Goods goodsDtoToGoods(GoodsDto goodsDto);

    List<GoodsDto> goodsListToGoodsDtoList(List<Goods> goodsList);
}
