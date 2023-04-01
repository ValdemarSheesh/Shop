package com.example.Shop.service.impl;

import com.example.Shop.exceptions.NotFoundException;
import com.example.Shop.model.Goods;
import com.example.Shop.repo.GoodsRepository;
import com.example.Shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public Goods addGoods(Goods goods) {
        return goodsRepository.saveAndFlush(goods);
    }

    @Override
    public Goods getGoodsById(Long id) {
        return goodsRepository.findById(id).orElseThrow(() -> new NotFoundException("Goods with id " + id + " not found"));
    }

    @Override
    public List<Goods> getAllGoods() {
        return goodsRepository.findAll();
    }

    @Override
    public Goods editGoods(Goods goods) {
        getGoodsById(goods.getId());
        return goodsRepository.saveAndFlush(goods);
    }

    @Override
    public void deleteGoods(Long id) {
        goodsRepository.delete(getGoodsById(id));
    }
}
