package com.cy.school1.mapper;

import com.cy.school1.entity.Course;
import com.cy.school1.entity.OrderItem;
import com.cy.school1.entity.SCOrder;
import com.cy.school1.vo.OrderVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderMapperTests {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void insertOrder(){
        SCOrder scOrder = new SCOrder();
        scOrder.setSno("3221702938");
        scOrder.setCno("11002");
        orderMapper.insertOrder(scOrder);
    }

    @Test
    public void insertOrderItem(){
        OrderItem orderItem = new OrderItem();
        orderItem.setSno("3221702938");
        orderItem.setCno("11002");
        orderMapper.insertOrderItem(orderItem);
    }

    @Test
    public void findAllOrderItems(){
        List<OrderVO> list = orderMapper.findAllOrderItems();
        System.out.println(list);
    }

    @Test
    public void findOrderItemsByScid(){
        List<OrderVO> list = orderMapper.findOrderItemsByScid(7);
        System.out.println(list);
    }

    @Test
    public void findByCondition(){
        OrderVO orderVO = new OrderVO();
        orderVO.setScid(7);
        orderVO.setSno("3221702938");
//        orderVO.setCno("");
        List<OrderVO> list = orderMapper.findByCondition(orderVO);
        System.out.println(list);
    }

    @Test
    public void findBySno(){
        List<OrderVO> list = orderMapper.findBySno("3221702938");
        System.out.println(list);
    }
}
