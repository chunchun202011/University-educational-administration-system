package com.cy.school1.service;

import com.cy.school1.entity.SCOrder;
import com.cy.school1.entity.ScoreRecord;
import com.cy.school1.vo.OrderVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@MapperScan("com.cy.school1.mapper")
@SpringBootTest
@RunWith(SpringRunner.class)
public class ScoreOrderServiceTests {

    @Autowired
    private IScoreOrderService scoreOrderService;

    @Test
    public void create(){
        String[] snos = {"1243123111","3221702938"};
        ScoreRecord scoreRecord = scoreOrderService.create(snos,"11007","12312941");
        System.out.println(scoreRecord);
    }

}
