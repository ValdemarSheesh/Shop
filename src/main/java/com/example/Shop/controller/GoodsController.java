package com.example.Shop.controller;

import com.example.Shop.dto.GoodsDto;
import com.example.Shop.exceptions.InvalidValueException;
import com.example.Shop.mapper.GoodsMapper;
import com.example.Shop.model.Goods;
import com.example.Shop.service.impl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsServiceImpl goodsService;

    @PostMapping
    public ResponseEntity<?> saveGoods(@Validated @RequestBody GoodsDto goodsDto,
                                       BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new InvalidValueException(InvalidValueException.createMessage(bindingResult));
        }

        Goods goods = GoodsMapper.INSTANCE.goodsDtoToGoods(goodsDto);

        return ResponseEntity.ok(GoodsMapper.INSTANCE.goodsToGoodsDto(goodsService.addGoods(goods)));
    }

    @PutMapping
    public ResponseEntity<?> updateGoods(@Validated @RequestBody GoodsDto goodsDto,
                                         BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new InvalidValueException(InvalidValueException.createMessage(bindingResult));
        }

        Goods goods = GoodsMapper.INSTANCE.goodsDtoToGoods(goodsDto);

        return ResponseEntity.ok(GoodsMapper.INSTANCE.goodsToGoodsDto(goodsService.editGoods(goods)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGoods(@PathVariable Long id) {
        Goods goods = goodsService.getGoodsById(id);
        return ResponseEntity.ok(GoodsMapper.INSTANCE.goodsToGoodsDto(goods));
    }

    @GetMapping
    public ResponseEntity<?> getAllGoods() {
        List<Goods> goodsList = goodsService.getAllGoods();
        if (goodsList.isEmpty())
            return ResponseEntity.ok("Goods is empty");
        else
            return ResponseEntity.ok(GoodsMapper.INSTANCE.goodsListToGoodsDtoList(goodsList));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteGoods(@RequestParam(value = "id") Long id) {
        goodsService.deleteGoods(id);
        return ResponseEntity.ok("Goods deleted");
    }
}
