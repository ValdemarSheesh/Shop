package com.example.Shop.service;

import com.example.Shop.model.Goods;
import com.example.Shop.model.Order;
import com.example.Shop.model.OrderLine;
import com.example.Shop.repo.GoodsRepository;
import com.example.Shop.repo.OrderLineRepository;
import com.example.Shop.repo.OrderRepository;
import com.example.Shop.service.impl.GoodsServiceImpl;
import com.example.Shop.service.impl.OrderLineServiceImpl;
import com.example.Shop.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class OrderLineServiceTest {

    @Mock
    private OrderLineRepository orderLineRepository;

    @InjectMocks
    private OrderLineServiceImpl orderLineService;

    private OrderLine orderLine;

    @BeforeEach
    public void setup() {
        orderLine = orderLine.builder()
                .id(1L)
                .goodsList(Collections.emptyList())
                .build();
    }

    @Test
    public void addOrderLineTest() {
        given(orderLineRepository.saveAndFlush(orderLine)).willReturn(orderLine);

        OrderLine savedOrderLine = orderLineService.addOrderLine(orderLine);

        assertThat(savedOrderLine).isNotNull();
    }

    @Test
    public void getAllLineOrderTest() {
        OrderLine orderLine1 = orderLine.builder()
                .id(1L)
                .goodsList(Collections.emptyList())
                .build();

        given(orderLineRepository.findAll()).willReturn(List.of(orderLine, orderLine1));

        List<OrderLine> orderLineList = orderLineService.getAllOrderLine();

        assertThat(orderLineList).isNotNull();
        assertThat(orderLineList.size()).isEqualTo(2);
    }

    @Test
    public void getAllLineOrderTestWithEmptyList() {
        OrderLine orderLine1 = orderLine.builder()
                .id(1L)
                .goodsList(Collections.emptyList())
                .build();

        given(orderLineRepository.findAll()).willReturn(Collections.emptyList());

        List<OrderLine> orderLineList = orderLineService.getAllOrderLine();

        assertThat(orderLineList).isNotNull();
        assertThat(orderLineList.size()).isEqualTo(0);
    }

    @Test
    public void getOrderLineByIdTest() {
        given(orderLineRepository.findById(orderLine.getId())).willReturn(Optional.of(orderLine));

        OrderLine foundOrderLine = orderLineService.getOrderLineById(orderLine.getId());

        assertThat(foundOrderLine).isNotNull();
    }

    @Test
    public void editOrderLineTest() {
        given(orderLineRepository.findById(orderLine.getId())).willReturn(Optional.of(orderLine));
        given(orderLineRepository.saveAndFlush(orderLine)).willReturn(orderLine);

        OrderLine editedOrderLine = orderLineService.editOrderLine(orderLine);

        assertThat(editedOrderLine).isNotNull();
    }

    @Test
    public void deleteOrderLineTest() {
        given(orderLineRepository.findById(orderLine.getId())).willReturn(Optional.of(orderLine));
        willDoNothing().given(orderLineRepository).delete(orderLine);

        orderLineService.deleteOrderLine(orderLine.getId());

        verify(orderLineRepository, times(1)).delete(orderLine);
    }

}


















