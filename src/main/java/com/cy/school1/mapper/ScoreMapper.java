package com.cy.school1.mapper;

import com.cy.school1.entity.Score;
import com.cy.school1.vo.ScoreVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;


/* 成绩持久层的接口 */
public interface ScoreMapper {
    /**
     * 插入学生的成绩数据
     * @param score 成绩数据
     * @return 受影响的行数
     */
     Integer insert(Score score);

    /**
     * 根据学生的学号统计成绩数量
     * @param sno 学号
     * @return 当前学生的成绩总数
     */
    Integer countBySno(String sno);

    /**
     * 根据学号查询成绩数据
     */
    List<Score> findScoreBySno();

    /**
     * 查询某个学生的成绩
     * 查询学号、学生名、课程号、课程名、成绩
     */
    List<ScoreVO> findVOBySno(String sno);

    /**
     * 查询所有学生的成绩
     * 学号、学生名、课程号、课程名、成绩
     */
    List<ScoreVO> findAllScores();

    /**
     * 根据学号、课程号删除成绩
     * @param sno
     * @param cno
     * @return
     */
    Integer deleteScore(String sno,String cno);

    //查询
    Score findScoreBySnoCno(String sno,String cno);

    /**
     * 查询我的的成绩（与课程表联立）
     */
    List<ScoreVO> findMyScore(String sno);

//    Integer updateGrade(String sno,String cno,Integer grade);

    Integer updateAScore(Score score);

//    /**
//     * 插入数据列表
//     *
//     * @param scores 数据列表
//     */
//    void insertScoresList(@Param("scores") List<Score> scores);


}
