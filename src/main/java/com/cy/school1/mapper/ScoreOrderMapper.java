package com.cy.school1.mapper;

import com.cy.school1.entity.OrderItem;
import com.cy.school1.entity.SCOrder;
import com.cy.school1.entity.ScoreItem;
import com.cy.school1.entity.ScoreRecord;
import com.cy.school1.vo.OrderVO;
import com.cy.school1.vo.ScoreVO;

import java.util.List;

/** 选课单的持久层接口 */
public interface ScoreOrderMapper {
    /**
     * 插入选课单数据
     * @param scoreRecord 选课单数据
     * @return 受影响的行数
     */
    Integer insertRecord(ScoreRecord scoreRecord);

    /**
     * 插入成绩单项的数据
     * @param scoreItem 成绩单项数据
     * @return 受影响的行数
     */
    Integer insertScoreItem(ScoreItem scoreItem);

    /** 找出所有成绩单数据 */
    List<ScoreVO> findAllScoreItems();

//    /** 查找某个选课单的数据 */
//    List<OrderVO> findScoreItemsByScid(Integer so);

    /** 选中学号查成绩 */
    List<ScoreVO> findScoreItemsBySno(String sno);

    /** 选中课程号查成绩 */
    List<ScoreVO> findScoreItemsByCno(String[] snos,String cno);

//    /** 查找学生个人的订单数据 */
//    List<OrderVO> findBySno(String sno);

    /* 根据学号列表查询成绩 */
    List<ScoreVO> findScoreVOBySnos(String[] snos);
}
