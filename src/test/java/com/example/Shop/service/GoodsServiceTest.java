package com.example.Shop.service;

import com.example.Shop.model.Goods;
import com.example.Shop.repo.GoodsRepository;
import com.example.Shop.service.impl.GoodsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class GoodsServiceTest {

    @Mock
    private GoodsRepository goodsRepository;

    @InjectMocks
    private GoodsServiceImpl goodsService;

    private Goods goods;

    @BeforeEach
    public void setup() {
        goods = goods.builder()
                .id(1L)
                .name("goodsName")
                .price(99.99)
                .build();
    }

    @Test
    public void addGoodsTest() {
        given(goodsRepository.saveAndFlush(goods)).willReturn(goods);

        Goods savedGoods = goodsService.addGoods(goods);

        assertThat(savedGoods).isNotNull();
    }

    @Test
    public void getAllGoodsTest() {
        Goods goods1 = goods.builder()
                .id(1L)
                .name("goodsName")
                .price(99.99)
                .build();

        given(goodsRepository.findAll()).willReturn(List.of(goods, goods1));

        List<Goods> goodsList = goodsService.getAllGoods();

        assertThat(goodsList).isNotNull();
        assertThat(goodsList.size()).isEqualTo(2);
    }

    @Test
    public void getAllGoodsTestWithEmptyList() {
        given(goodsRepository.findAll()).willReturn(Collections.emptyList());

        List<Goods> goodsList = goodsService.getAllGoods();

        assertThat(goodsList).isNotNull();
        assertThat(goodsList.size()).isEqualTo(0);
    }

    @Test
    public void getGoodsByIdTest() {
        given(goodsRepository.findById(goods.getId())).willReturn(Optional.of(goods));

        Goods foundGoods = goodsService.getGoodsById(goods.getId());

        assertThat(foundGoods).isNotNull();
    }

    @Test
    public void editGoodsTest() {
        given(goodsRepository.findById(goods.getId())).willReturn(Optional.of(goods));
        given(goodsRepository.saveAndFlush(goods)).willReturn(goods);
        goodsService.addGoods(goods);
        goods.setName("newName");
        goods.setPrice(55.55);

        Goods editedGoods = goodsService.editGoods(goods);

        assertThat(editedGoods.getName()).isEqualTo(goods.getName());
        assertThat(editedGoods.getPrice()).isEqualTo(goods.getPrice());
    }

    @Test
    public void deleteGoodsTest() {
        given(goodsRepository.findById(goods.getId())).willReturn(Optional.of(goods));
        willDoNothing().given(goodsRepository).delete(goods);

        goodsService.deleteGoods(goods.getId());

        verify(goodsRepository, times(1)).delete(goods);
    }
}

















