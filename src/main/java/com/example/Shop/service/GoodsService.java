package com.example.Shop.service;

import com.example.Shop.model.Goods;

import java.util.List;

public interface GoodsService {

    Goods addGoods(Goods goods);

    Goods getGoodsById(Long id);

    List<Goods> getAllGoods();

    Goods editGoods(Goods goods);

    void deleteGoods(Long id);
}
