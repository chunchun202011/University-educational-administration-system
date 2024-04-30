package com.cy.school1.mapper;

import com.cy.school1.entity.ScoreItem;
import com.cy.school1.entity.WaitScore;
import com.cy.school1.vo.ScoreVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class WaitScoreMapperTests {

    @Autowired
    private WaitScoreMapper waitScoreMapper;

    @Test
    public void insertWaitScore(){
        WaitScore waitScore = new WaitScore();
        waitScore.setCno("10213");
        waitScore.setCreatedUser("丁迪");
        waitScore.setCreatedTime(new Date());
        waitScore.setModifiedUser("丁迪");
        waitScore.setModifiedTime(new Date());
        Integer rows = waitScoreMapper.insertWaitScore(waitScore);
        System.out.println(rows);
    }

    @Test
    public void insertScoreItem(){
        ScoreItem scoreItem = new ScoreItem();
        scoreItem.setSno("111111111");
        scoreItem.setCno("11111");
        scoreItem.setGrade(90);
        Integer rows = waitScoreMapper.insertScoreItem(scoreItem);
        System.out.println(rows);
    }

    @Test
    public void findWaitScoreByCno(){
        WaitScore waitScore = waitScoreMapper.findWaitScoreByCno("10212");
        System.out.println(waitScore);
    }

    @Test
    public void findAllScores(){
        List<ScoreVO> scores = waitScoreMapper.findAllScores();
        System.out.println(scores);
    }

    @Test
    public void findTStuScores(){
        List<ScoreVO> scores = waitScoreMapper.findTStuScore("12312941");
        System.out.println(scores);
    }

    @Test
    public void deleteScoreItem(){
        Integer rows = waitScoreMapper.deleteScoreItem("1362671","1201");
        System.out.println(rows);
    }
    @Test
    public void updateAScoreItems(){
        ScoreItem scoreItem = waitScoreMapper.findScoreItemBySnoCno("1234","1132");
        scoreItem.setGrade(92);
        scoreItem.setModifiedUser("管理员");
        scoreItem.setModifiedTime(new Date());
        Integer rows = waitScoreMapper.updateAScoreItem(scoreItem);
        System.out.println(rows);
    }

    @Test
    public void findByConditionAnd(){
        List<ScoreVO> scores = waitScoreMapper.selectByConditionAnd("sno","3","sname","林");
        System.out.println(scores);
    }

    @Test
    public void findMyAddScore(){
        List<ScoreVO> scores = waitScoreMapper.findMyAddScore("12312941");
        System.out.println(scores);
    }

    @Test
    public void selectByConditionTAnd(){
        List<ScoreVO> scores = waitScoreMapper.selectByConditionTAnd("12312941","sno","3","sname","林");
        System.out.println(scores);
    }
}
