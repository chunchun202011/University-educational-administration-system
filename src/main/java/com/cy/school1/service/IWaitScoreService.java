package com.cy.school1.service;

import com.cy.school1.entity.SCOrder;
import com.cy.school1.entity.ScoreItem;
import com.cy.school1.entity.WaitScore;
import com.cy.school1.vo.CourseVO;
import com.cy.school1.vo.OrderVO;
import com.cy.school1.vo.ScoreVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IWaitScoreService {

    WaitScore addToWaitScore(String tno,String cno);

    // 创建成绩单（一门课，多个学生成绩）
//    WaitScore create(String tno, String cno, String[] snos);

//    List<OrderVO> findAllOrderItems();
//
//    List<OrderVO> findOrderItemsByScid(Integer scid);
//
//    List<OrderVO> findByCondition(OrderVO orderVO);
//
//    List<OrderVO> findBySno(String sno);

    // 创建成绩单（一门课，多个学生成绩）
   void create(String tno, String cno, List<ScoreItem> scoreItems);

    // 创建成绩单（一门课，一个学生成绩）
    void createOne(String tno, String cno,String sno,Integer grade);

    //查询所有学生成绩
    List<ScoreVO> findAllScores();

    //查询教师教的学生成绩
    List<ScoreVO> findTStuScore(String tno);

    //更新成绩
    Integer updateScoreItem(String tno, String sno,String cno,Integer grade);

    //删除成绩
    Integer deleteScoreItem(String sno,String cno);

    //多条件查询
    List<ScoreVO> selectByConditionAnd(@Param("key1") String key1, @Param("value1") String value1,
                                     @Param("key2") String key2, @Param("value2") String value2);

    List<ScoreVO> findMyScore(String sno);

    List<ScoreVO> findMyAddScore(String tno);

 //教师多条件查询学生成绩
 List<ScoreVO> selectByConditionTAnd(String tno,
         @Param("key1") String key1, @Param("value1") String value1,
         @Param("key2") String key2, @Param("value2") String value2);

}
