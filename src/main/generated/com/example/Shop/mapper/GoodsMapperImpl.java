package com.example.Shop.mapper;

import com.example.Shop.dto.GoodsDto;
import com.example.Shop.model.Goods;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-31T19:53:28+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
public class GoodsMapperImpl implements GoodsMapper {

    @Override
    public GoodsDto goodsToGoodsDto(Goods goods) {
        if ( goods == null ) {
            return null;
        }

        GoodsDto goodsDto = new GoodsDto();

        goodsDto.setId( goods.getId() );
        goodsDto.setName( goods.getName() );
        goodsDto.setPrice( goods.getPrice() );

        return goodsDto;
    }

    @Override
    public Goods goodsDtoToGoods(GoodsDto goodsDto) {
        if ( goodsDto == null ) {
            return null;
        }

        Goods goods = new Goods();

        goods.setId( goodsDto.getId() );
        goods.setName( goodsDto.getName() );
        goods.setPrice( goodsDto.getPrice() );

        return goods;
    }

    @Override
    public List<GoodsDto> goodsListToGoodsDtoList(List<Goods> goodsList) {
        if ( goodsList == null ) {
            return null;
        }

        List<GoodsDto> list = new ArrayList<GoodsDto>( goodsList.size() );
        for ( Goods goods : goodsList ) {
            list.add( goodsToGoodsDto( goods ) );
        }

        return list;
    }
}
