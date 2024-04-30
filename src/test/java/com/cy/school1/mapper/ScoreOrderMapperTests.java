package com.cy.school1.mapper;

import com.cy.school1.entity.OrderItem;
import com.cy.school1.entity.SCOrder;
import com.cy.school1.entity.ScoreItem;
import com.cy.school1.entity.ScoreRecord;
import com.cy.school1.vo.OrderVO;
import com.cy.school1.vo.ScoreVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ScoreOrderMapperTests {

    @Autowired
    private ScoreOrderMapper scoreOrderMapper;

    @Test
    public void insertScoreRecord(){
        ScoreRecord scoreRecord = new ScoreRecord();
        scoreRecord.setSno("1243123111");
        scoreRecord.setCno("00220");
        Integer rows = scoreOrderMapper.insertRecord(scoreRecord);
        System.out.println(rows);
    }

    @Test
    public void insertScoreItem(){
        ScoreItem scoreItem = new ScoreItem();
        scoreItem.setSno("1243123111");
        scoreItem.setCno("00220");
        scoreItem.setGrade(90);
        Integer rows = scoreOrderMapper.insertScoreItem(scoreItem);
        System.out.println(rows);
    }

    @Test
    public void findAllScoreItems(){
        List<ScoreVO> scoreVOs = scoreOrderMapper.findAllScoreItems();
        System.out.println(scoreVOs);
    }

    @Test
    public void findScoreItemsBySno(){
        List<ScoreVO> scoreVOs = scoreOrderMapper.findScoreItemsBySno("1243123111");
        System.out.println(scoreVOs);
    }

}
