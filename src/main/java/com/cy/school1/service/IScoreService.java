package com.cy.school1.service;

import com.cy.school1.entity.Score;
import com.cy.school1.vo.ScoreVO;

import java.util.List;

/* 成绩业务层接口 */
public interface IScoreService {
    void addNewScore(String sno,String cno,String tno,Score score);
//  void addNewScore(String sno,String tno,Integer grade);
//void addNewScore(String sno,Score score);

    /* 查询单个学生成绩 */
    List<ScoreVO> getVOBySno(String sno);

    /* 查询所有学生成绩 */
    List<ScoreVO> findAllScores();

    /*
    * 删除成绩
    * */
    void deleteScore(String sno,String cno);

    /* 根据学号、课程号查成绩 */
    Score findScoreBySnoCno(String sno,String cno);

    List<ScoreVO> findMyScore(String sno);

//    Integer updateScore(String sno,String cno,Integer grade,String tno);
    Integer updateAScore(String sno,String cno,Integer grade,String tno);


}

