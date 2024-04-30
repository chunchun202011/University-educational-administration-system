package com.cy.school1.mapper;

import com.cy.school1.entity.OrderItem;
import com.cy.school1.entity.SCOrder;
import com.cy.school1.vo.OrderVO;

import java.util.List;

/** 选课单的持久层接口 */
public interface OrderMapper {
    /**
     * 插入选课单数据
     * @param scOrder 选课单数据
     * @return 受影响的行数
     */
    Integer insertOrder(SCOrder scOrder);

    /**
     * 插入选课单项的数据
     * @param orderItem 选课单项数据
     * @return 受影响的行数
     */
    Integer insertOrderItem(OrderItem orderItem);

    /** 找出所有选课单数据 */
    List<OrderVO> findAllOrderItems();

    /** 查找某个选课单的数据 */
    List<OrderVO> findOrderItemsByScid(Integer scid);

    /** 多条件查询 */
    List<OrderVO> findByCondition(OrderVO orderVO);

    /** 查找学生个人的订单数据 */
    List<OrderVO> findBySno(String sno);
}
