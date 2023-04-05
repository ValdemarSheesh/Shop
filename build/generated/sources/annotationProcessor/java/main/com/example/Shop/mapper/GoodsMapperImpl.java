package com.example.Shop.mapper;

import com.example.Shop.dto.GoodsDto;
import com.example.Shop.model.Goods;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-05T21:51:29+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 19.0.2 (Oracle Corporation)"
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

        Goods.GoodsBuilder goods = Goods.builder();

        goods.id( goodsDto.getId() );
        goods.name( goodsDto.getName() );
        goods.price( goodsDto.getPrice() );

        return goods.build();
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
