package com.cy.school1.service.impl;

import com.cy.school1.entity.Course;
import com.cy.school1.entity.OrderItem;
import com.cy.school1.entity.SC;
import com.cy.school1.entity.SCOrder;
import com.cy.school1.mapper.OrderMapper;
import com.cy.school1.service.ICourseService;
import com.cy.school1.service.IOrderService;
import com.cy.school1.service.ISCService;
import com.cy.school1.service.ex.InsertException;
import com.cy.school1.vo.OrderVO;
import com.cy.school1.vo.SCVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ICourseService courseService;
    @Autowired
    private ISCService scService;

    @Override
    public SCOrder create(String sno, String sname, String[] cnos) {
        //即将下单的列表
        List<SCVO> list = scService.getVOByCno(sno,cnos);
        //计算总学分
        Integer totalCredit = 0;
        for (SCVO scvo : list){
//            totalCredit += scvo.getCredit() * scvo.getTerm();
        }
        SCOrder order = new SCOrder();
        order.setSno(sno);
//        for (String cno :cnos){
//            order.setCno(cno);
//        }
        // 状态、总学分、时间
        order.setStatus(0);
        order.setTotalCredit(totalCredit);
        order.setOrderTime(new Date());
        //日志
        order.setCreatedUser(sname);
        order.setCreatedTime(new Date());
        order.setModifiedUser(sname);
        order.setModifiedTime(new Date());
        //查询数据
        Integer rows = orderMapper.insertOrder(order);
        if (rows != 1){
            throw new InsertException("插入时异常！");
        }


        //创建选课单详细项的信息
        for (SCVO sc :list){
            //创建一个选课单项数据对象
            OrderItem orderItem = new OrderItem();
            orderItem.setScid(order.getScid());
            orderItem.setSno(sc.getSno());
            orderItem.setCno(sc.getCno());
            orderItem.setCredit(sc.getCredit());
            orderItem.setCname(sc.getCname());
//            orderItem.setTerm(sc.getTerm());
            //日志字段
            orderItem.setCreatedUser(sname);
            orderItem.setCreatedTime(new Date());
            orderItem.setModifiedUser(sname);
            orderItem.setModifiedTime(new Date());
            //插入数据
            orderMapper.insertOrderItem(orderItem);
        }

        return order;
    }

    @Override
    public List<OrderVO> findAllOrderItems() {
        List<OrderVO> list = orderMapper.findAllOrderItems();
        return list;
    }

    @Override
    public List<OrderVO> findOrderItemsByScid(Integer scid) {
        List<OrderVO> list = orderMapper.findOrderItemsByScid(scid);
        return list;
    }

    @Override
    public List<OrderVO> findByCondition(OrderVO orderVO) {
        List<OrderVO> list = orderMapper.findByCondition(orderVO);
        return list;
    }

    @Override
    public List<OrderVO> findBySno(String sno) {
        List<OrderVO> list = orderMapper.findBySno(sno);
        return list;
    }
}
