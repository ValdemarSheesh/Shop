package com.example.Shop.repo;

import com.example.Shop.ShopApplication;
import com.example.Shop.model.Goods;
import com.example.Shop.model.Order;
import com.example.Shop.model.OrderLine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Transactional
@SpringBootTest(classes = ShopApplication.class)
public class OrderLineTest {

    @Autowired
    private OrderLineRepository orderLineRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private GoodsRepository goodsRepository;

    @Test
    public void testFindById() {
        OrderLine orderLine = getOrderLine();
        orderLineRepository.saveAndFlush(orderLine);
        OrderLine result = orderLineRepository.findById(orderLine.getId()).get();
        assertEquals(orderLine.getId(), result.getId());
    }

    @Test
    public void testSaveAndFlush() {
        OrderLine orderLine = getOrderLine();
        orderLineRepository.saveAndFlush(orderLine);
        OrderLine found = orderLineRepository.findById(orderLine.getId()).get();
        assertEquals(orderLine.getId(), found.getId());
    }

    @Test
    public void testDeleteById() {
        OrderLine orderLine = getOrderLine();
        orderLineRepository.saveAndFlush(orderLine);
        orderLineRepository.delete(orderLine);
        List<OrderLine> result = orderLineRepository.findAll();
        assertEquals(result.size(), 0);
    }

    @Test
    public void testFindAll() {
        OrderLine orderLine = getOrderLine();
        orderLineRepository.saveAndFlush(orderLine);
        List<OrderLine> result = orderLineRepository.findAll();
        assertEquals(result.size(), 1);
    }

    private OrderLine getOrderLine() {
        OrderLine orderLine = new OrderLine();

        Order order = new Order();
        order.setDate(LocalDate.now());
        order.setClient("clientName");
        order.setAddress("address");
        orderRepository.saveAndFlush(order);


        orderLine.setOrder(order);

        Goods goods = new Goods();
        goods.setName("nameGoods");
        goods.setPrice(99.99);
        goodsRepository.saveAndFlush(goods);

        orderLine.setGoodsList(List.of(goods));
        orderLine.setCount(99.99);

        return orderLine;
    }
}
