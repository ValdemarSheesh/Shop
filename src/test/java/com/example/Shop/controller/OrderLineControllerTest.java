package com.example.Shop.controller;

import com.example.Shop.model.OrderLine;
import com.example.Shop.service.impl.OrderLineServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderLineController.class)
public class OrderLineControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private OrderLineServiceImpl orderLineService;

    @Autowired
    private ObjectMapper objectMapper;

    private OrderLine orderLine;

    @BeforeEach
    public void setup() {
        orderLine = orderLine.builder()
                .id(1L)
                .goodsList(Collections.emptyList())
                .build();
    }

    @Test
    public void saveOrderLineTest() throws Exception {
        when(orderLineService.addOrderLine(any(OrderLine.class))).thenReturn(orderLine);

        mvc.perform(post("/orderLine")
                        .content(objectMapper.writeValueAsString(orderLine))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count", is(0.0)));
    }

    @Test
    public void getAllOrderLineTest() throws Exception {
        OrderLine orderLine1 = orderLine = orderLine.builder()
                .id(2L)
                .goodsList(Collections.emptyList())
                .build();
        List<OrderLine> orderLineList = List.of(orderLine, orderLine1);

        when(orderLineService.getAllOrderLine()).thenReturn(orderLineList);

        mvc.perform(get("/orderLine"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(orderLineList.size())));
    }

    @Test
    public void getOrderLineByIdTest() throws Exception {
        when(orderLineService.getOrderLineById(orderLine.getId())).thenReturn(orderLine);

        mvc.perform(get("/orderLine/{id}", orderLine.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count", is(0.0)));
    }

    @Test
    public void updateOrderLineTest() throws Exception {
        when(orderLineService.editOrderLine(any(OrderLine.class))).thenReturn(orderLine);

        mvc.perform(put("/orderLine")
                        .content(objectMapper.writeValueAsString(orderLine))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count", is(0.0)));
    }

    @Test
    public void deleteOrderLineTest() throws Exception {
        doNothing().when(orderLineService).deleteOrderLine(orderLine.getId());

        mvc.perform(delete("/orderLine?id={id}", anyLong()))
                .andExpect(status().isOk());
    }
}






















