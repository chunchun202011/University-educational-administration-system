package com.cy.school1.mapper;

import com.cy.school1.entity.*;
import com.cy.school1.vo.CourseVO;
import com.cy.school1.vo.OrderVO;
import com.cy.school1.vo.ScoreVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/** 选课单的持久层接口 */
public interface WaitScoreMapper {

    /**
     * 插入成绩单数据
     * @param waitScore 成绩单数据
     * @return 受影响的行数
     */
    Integer insertWaitScore(WaitScore waitScore);

    WaitScore findWaitScoreByCno(String cno);

    /**
     * 插入成绩单项的数据
     * @param scoreItem 选课单项数据
     * @return 受影响的行数
     */
    Integer insertScoreItem(ScoreItem scoreItem);

    List<ScoreVO> getVOByCno(String cno,@Param("snos") String[] snos);

    List<ScoreVO> findAllScores();

    List<ScoreVO> findTStuScore(String tno);

    /**
     * 根据学号、课程号删除成绩
     * @param sno
     * @param cno
     * @return
     */
    Integer deleteScoreItem(String sno,String cno);

    Integer updateAScoreItem(ScoreItem scoreItem);

    ScoreItem findScoreItemBySnoCno(String sno,String cno);

    //三个条件查询所有成绩
    List<ScoreVO> selectByConditionAnd(@Param("key1") String key1, @Param("value1") String value1,
                                        @Param("key2") String key2, @Param("value2") String value2);

    List<ScoreVO> selectByConditionOr(@Param("key1") String key1,@Param("value1") String value1,
                                       @Param("key2") String key2,@Param("value2") String value2);
    List<ScoreVO> selectByConditionNot(@Param("key1") String key1,@Param("value1") String value1,
                                        @Param("key2") String key2,@Param("value2") String value2);


    List<ScoreVO> findMyAddScore(String tno);

    //三个条件查询所有成绩
    List<ScoreVO> selectByConditionTAnd(@Param("tno") String tno,
                                        @Param("key1") String key1, @Param("value1") String value1,
                                       @Param("key2") String key2, @Param("value2") String value2);
//
//    /** 找出所有选课单数据 */
//    List<OrderVO> findAllOrderItems();
//
//    /** 查找某个选课单的数据 */
//    List<OrderVO> findOrderItemsByScid(Integer scid);
//
//    /** 多条件查询 */
//    List<OrderVO> findByCondition(OrderVO orderVO);
//
//    /** 查找学生个人的订单数据 */
//    List<OrderVO> findBySno(String sno);
}
