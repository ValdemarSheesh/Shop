package com.example.Shop.repo;

import com.example.Shop.ShopApplication;
import com.example.Shop.model.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
@SpringBootTest(classes = ShopApplication.class)
public class GoodsRepoTest {

    @Autowired
    private GoodsRepository goodsRepository;

    @Test
    public void testFindById() {
        Goods goods = getGoods();
        goodsRepository.saveAndFlush(goods);
        Goods result = goodsRepository.findById(goods.getId()).get();
        assertEquals(goods.getId(), result.getId());
    }

    @Test
    public void testSaveAndFlush() {
        Goods goods = getGoods();
        goodsRepository.saveAndFlush(goods);
        Goods found = goodsRepository.findById(goods.getId()).get();
        assertEquals(goods.getId(), found.getId());
    }

    @Test
    public void testDeleteById() {
        Goods goods = getGoods();
        goodsRepository.saveAndFlush(goods);
        goodsRepository.delete(goods);
        List<Goods> result = goodsRepository.findAll();
        assertEquals(result.size(), 0);
    }

    @Test
    public void testFindAll() {
        Goods goods = getGoods();
        goodsRepository.saveAndFlush(goods);
        List<Goods> result = goodsRepository.findAll();
        assertEquals(result.size(), 1);
    }

    private Goods getGoods() {
        Goods goods = new Goods();
        goods.setName("nameGoods");
        goods.setPrice(99.99);
        return goods;
    }
}
