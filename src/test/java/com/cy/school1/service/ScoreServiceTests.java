package com.cy.school1.service;

import com.cy.school1.entity.Score;
import com.cy.school1.vo.ScoreVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

// @SpringBootTest:表示标注当前的类是一个测试类，不会随同项目一块打包发送
@SpringBootTest
// @RunWith:表示启动这个单元测试类(单元测试类是不能运行的)，需要传递一个参数，必须是SpringRunner的实例类型
@RunWith(SpringRunner.class)
public class ScoreServiceTests {

    //idea有检测的功能，接口是不能够直接创建Bean的(动态代理技术来解决)
    @Autowired
    private IScoreService scoreService;

//    @Test
//    public void addNewScore(){
//        Score score = new Score();
//        score.setSdeno(1);
//        score.setSno("3221702938");
//        score.setCno("00214");
//        score.setGrade(90);
//        scoreService.addNewScore("3221702938","12312941",score);
//    }

    @Test
    public void addNewScore(){
        Score score = new Score();
        score.setSdeno("001");
        score.setSno("3271821624");
        score.setCno("00212");
        score.setCreatedUser("12312941");
        score.setGrade(89);
        scoreService.addNewScore("3271821624","00212","12312941",score);
    }

    @Test
    public void deleteScore(){
        String sno = "3221702938";
        String cno = "00220";
        scoreService.deleteScore(sno,cno);
    }

    @Test
    public void findScoreBySnoCno(){
        Score score = scoreService.findScoreBySnoCno("3221702938","00220");
        System.out.println(score);
    }

    @Test
    public void findMyScore(){
        List<ScoreVO> list = scoreService.findMyScore("3221702938");
        System.out.println(list);
    }

    @Test
    public void updateAScore(){
       Integer rows = scoreService.updateAScore("3221702938","00220",93,"20127185");
        System.out.println(rows);

    }


}
