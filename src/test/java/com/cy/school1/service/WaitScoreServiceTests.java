package com.cy.school1.service;

import com.cy.school1.entity.SC;
import com.cy.school1.entity.ScoreItem;
import com.cy.school1.entity.WaitScore;
import com.cy.school1.vo.ScoreVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@MapperScan("com.cy.school1.mapper")
@SpringBootTest
@RunWith(SpringRunner.class)
public class WaitScoreServiceTests {

    @Autowired
    private IWaitScoreService waitScoreService;

    @Test
    public void insertWaitScore(){
      WaitScore result = waitScoreService.addToWaitScore("20127186","10214");
        System.out.println(result);
    }

    @Test
    public void create(){
        List<ScoreItem> list = new ArrayList<>();
        ScoreItem scoreItem1 = new ScoreItem();
        scoreItem1.setSno("32123");
        scoreItem1.setGrade(93);
        list.add(scoreItem1);
        ScoreItem scoreItem2 = new ScoreItem();
        scoreItem2.setSno("3242");
        scoreItem2.setGrade(89);
        list.add(scoreItem2);
        for(int i=0;i<list.size();i++){
            System.out.println(i+":"+list.get(i));
        }
       waitScoreService.create("11111","0104",list);
    }

    @Test
    public void createOne(){
        waitScoreService.createOne("11111","1201","1362671",90);
    }

    @Test
    public void findAllScores(){
        List<ScoreVO> scores = waitScoreService.findAllScores();
        System.out.println(scores);
    }

    @Test
    public void findTStuScore(){
        List<ScoreVO> scores = waitScoreService.findTStuScore("12312941");
        System.out.println(scores);
    }

    @Test
    public void findByConditionAnd(){
        List<ScoreVO> scores = waitScoreService.selectByConditionAnd("sr","1","sname","林");
        System.out.println(scores);
    }

    @Test
    public void findMyScore(){
       List<ScoreVO> list = waitScoreService.findMyScore("3221702950");
        System.out.println(list);
    }

}
