package com.cy.school1.service;

import com.cy.school1.entity.Course;
import com.cy.school1.entity.OrderItem;
import com.cy.school1.entity.SCOrder;
import com.cy.school1.vo.OrderVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@MapperScan("com.cy.school1.mapper")
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceTests {

    @Autowired
    private IOrderService orderService;

    @Test
    public void create(){
        String[] cnos = {"11003","11004"};
        SCOrder order = orderService.create("3221702938","林木",cnos);
        System.out.println(order);
    }

    @Test
    public void findAllOrderItems(){
        List<OrderVO> list = orderService.findAllOrderItems();
        System.out.println(list);
    }

    @Test
    public void findOrderItemsByScid(){
        List<OrderVO> list = orderService.findOrderItemsByScid(7);
        System.out.println(list);
    }

    @Test
    public void findByCondition(){
        OrderVO orderVO = new OrderVO();
        orderVO.setScid(7);
        orderVO.setSno("3221702938");
        List<OrderVO> list = orderService.findByCondition(orderVO);
        System.out.println(list);
    }

    @Test
    public void findBySno(){
        List<OrderVO> list = orderService.findBySno("3221702938");
        System.out.println(list);
    }
}
