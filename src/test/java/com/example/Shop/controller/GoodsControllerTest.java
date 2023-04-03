package com.example.Shop.controller;

import com.example.Shop.model.Goods;
import com.example.Shop.service.impl.GoodsServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GoodsController.class)
public class GoodsControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private GoodsServiceImpl goodsService;

    @Autowired
    private ObjectMapper objectMapper;

    private Goods goods;

    @BeforeEach
    public void setup() {
        goods = goods.builder()
                .id(1l)
                .name("name")
                .price(99.99)
                .build();
    }

    @Test
    public void saveGoodsTest() throws Exception {
        when(goodsService.addGoods(any(Goods.class))).thenReturn(goods);

        mvc.perform(post("/goods")
                        .content(objectMapper.writeValueAsString(goods))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(goods.getName())))
                .andExpect(jsonPath("$.price", is(goods.getPrice())));
    }

    @Test
    public void getAllGoods() throws Exception {
        Goods goods1 = goods.builder()
                .id(2l)
                .name("name")
                .price(99.99)
                .build();
        List<Goods> goodsList = List.of(goods, goods1);

        when(goodsService.getAllGoods()).thenReturn(goodsList);

        mvc.perform(get("/goods"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(goodsList.size())));
    }

    @Test
    public void getGoodsByIdTest() throws Exception {
        when(goodsService.getGoodsById(goods.getId())).thenReturn(goods);

        mvc.perform(get("/goods/{id}", goods.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(goods.getName())))
                .andExpect(jsonPath("$.price", is(goods.getPrice())));
    }

    @Test
    public void updateGoodsTest() throws Exception {
        when(goodsService.editGoods(any(Goods.class))).thenReturn(goods);

        mvc.perform(put("/goods")
                        .content(objectMapper.writeValueAsString(goods))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(goods.getName())))
                .andExpect(jsonPath("$.price", is(goods.getPrice())));
    }

    @Test
    public void deleteGoodsTest() throws Exception {
        doNothing().when(goodsService).deleteGoods(anyLong());

        mvc.perform(delete("/goods?id={id}", anyLong()))
                .andExpect(status().isOk());
    }

}

























