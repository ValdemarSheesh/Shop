package com.example.Shop.controller;

import com.example.Shop.model.Order;
import com.example.Shop.service.impl.OrderServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private OrderServiceImpl orderService;

    @Autowired
    private ObjectMapper objectMapper;

    private Order order;

    @BeforeEach
    public void setup() {
        order = order.builder()
                .id(1L)
                .client("name")
                .date(LocalDate.now())
                .address("address")
                .build();
    }

    @Test
    public void saveOrderTest() throws Exception {
        when(orderService.addOrder(any(Order.class))).thenReturn(order);

        mvc.perform(post("/orders")
                        .content(objectMapper.writeValueAsString(order))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.client", is(order.getClient())))
                .andExpect(jsonPath("$.date", is(order.getDate().toString())))
                .andExpect(jsonPath("$.address", is(order.getAddress())));
    }

    @Test
    public void getAllOrderTest() throws Exception {
        Order order1 = order.builder()
                .id(2L)
                .client("name")
                .date(LocalDate.now())
                .address("address")
                .build();
        List<Order> orders = List.of(order, order1);

        when(orderService.getAllOrder()).thenReturn(orders);

        mvc.perform(get("/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(orders.size())));
    }

    @Test
    public void getOrderByIdTest() throws Exception {
        when(orderService.getOrderById(order.getId())).thenReturn(order);

        mvc.perform(get("/orders/{id}", order.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.client", is(order.getClient())))
                .andExpect(jsonPath("$.date", is(order.getDate().toString())))
                .andExpect(jsonPath("$.address", is(order.getAddress())));
    }

    @Test
    public void updateOrderTest() throws Exception {
        when(orderService.editOrder(any(Order.class))).thenReturn(order);

        mvc.perform(put("/orders")
                        .content(objectMapper.writeValueAsString(order))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.client", is(order.getClient())))
                .andExpect(jsonPath("$.date", is(order.getDate().toString())))
                .andExpect(jsonPath("$.address", is(order.getAddress())));
    }

    @Test
    public void deleteOrderTest() throws Exception {
        doNothing().when(orderService).deleteOrder(anyLong());

        mvc.perform(delete("/orders?id={id}", anyLong()))
                .andExpect(status().isOk());
    }
}













