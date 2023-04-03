package com.example.Shop.service;

import com.example.Shop.model.Order;
import com.example.Shop.repo.OrderRepository;
import com.example.Shop.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    private Order order;

    @BeforeEach
    public void setup() {
        order = order.builder()
                .id(1L)
                .client("clientName")
                .date(LocalDate.now())
                .address("address")
                .build();
    }

    @Test
    public void addOrderTest() {
        given(orderRepository.saveAndFlush(order)).willReturn(order);

        Order savedOrder = orderService.addOrder(order);

        assertThat(savedOrder).isNotNull();
    }

    @Test
    public void getAllOrdersTest() {
        Order order1 = order.builder()
                .id(2L)
                .client("clientName")
                .date(LocalDate.now())
                .address("address")
                .build();

        given(orderRepository.findAll()).willReturn(List.of(order, order1));

        List<Order> orderList = orderService.getAllOrder();

        assertThat(orderList).isNotNull();
        assertThat(orderList.size()).isEqualTo(2);
    }

    @Test
    public void getAllOrdersTestWithEmptyList() {
        given(orderRepository.findAll()).willReturn(Collections.emptyList());

        List<Order> orderList = orderService.getAllOrder();

        assertThat(orderList).isNotNull();
        assertThat(orderList.size()).isEqualTo(0);
    }

    @Test
    public void getOrderByIdTest() {
        given(orderRepository.findById(order.getId())).willReturn(Optional.of(order));

        Order foundOrder = orderService.getOrderById(order.getId());

        assertThat(foundOrder).isNotNull();
    }

    @Test
    public void editOrderTest() {
        given(orderRepository.saveAndFlush(order)).willReturn(order);
        given(orderRepository.findById(order.getId())).willReturn(Optional.of(order));
        orderService.addOrder(order);
        order.setClient("newClientName");
        order.setAddress("newAddress");

        Order editedOrder = orderService.editOrder(order);

        assertThat(editedOrder.getClient()).isEqualTo(order.getClient());
        assertThat(editedOrder.getAddress()).isEqualTo(order.getAddress());
    }

    @Test
    public void deleteOrderTest() {
        given(orderRepository.findById(order.getId())).willReturn(Optional.of(order));
        willDoNothing().given(orderRepository).delete(order);

        orderService.deleteOrder(order.getId());

        verify(orderRepository, times(1)).delete(order);
    }
}












