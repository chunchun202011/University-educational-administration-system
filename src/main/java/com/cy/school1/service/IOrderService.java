package com.cy.school1.service;

import com.cy.school1.entity.Course;
import com.cy.school1.entity.OrderItem;
import com.cy.school1.entity.SC;
import com.cy.school1.entity.SCOrder;
import com.cy.school1.vo.OrderVO;

import java.util.List;

public interface IOrderService {

    SCOrder create(String sno, String sname, String cnos[]);

    List<OrderVO> findAllOrderItems();

    List<OrderVO> findOrderItemsByScid(Integer scid);

    List<OrderVO> findByCondition(OrderVO orderVO);

    List<OrderVO> findBySno(String sno);

}
