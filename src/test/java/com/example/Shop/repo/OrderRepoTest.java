package com.example.Shop.repo;

import com.example.Shop.ShopApplication;
import com.example.Shop.model.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Transactional
@SpringBootTest(classes = ShopApplication.class)
public class OrderRepoTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void findByIdTest() {
        Order order = getOrder();
        orderRepository.saveAndFlush(order);
        Order result = orderRepository.findById(order.getId()).get();
        assertEquals(order.getId(), result.getId());
    }

    @Test
    public void saveAndFlushTest() {
        Order order = getOrder();
        orderRepository.saveAndFlush(order);
        Order found = orderRepository.findById(order.getId()).get();
        assertEquals(order.getId(), found.getId());
    }

    @Test
    public void deleteByIdTest() {
        Order order = getOrder();
        orderRepository.saveAndFlush(order);
        orderRepository.delete(order);
        List<Order> result = orderRepository.findAll();
        assertEquals(result.size(), 0);
    }

    @Test
    public void findAllTest() {
        Order order = getOrder();
        orderRepository.saveAndFlush(order);
        List<Order> result = orderRepository.findAll();
        assertEquals(result.size(), 1);
    }

    private Order getOrder() {
        Order order = new Order();
        order.setDate(LocalDate.now());
        order.setClient("clientName");
        order.setAddress("address");
        return order;
    }
}
