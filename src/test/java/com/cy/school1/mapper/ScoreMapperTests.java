package com.cy.school1.mapper;

import com.cy.school1.entity.Score;
import com.cy.school1.vo.ScoreVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// @SpringBootTest:表示标注当前的类是一个测试类，不会随同项目一块打包发送
@SpringBootTest
// @RunWith:表示启动这个单元测试类(单元测试类是不能运行的)，需要传递一个参数，必须是SpringRunner的实例类型
@RunWith(SpringRunner.class)
public class ScoreMapperTests {

    //idea有检测的功能，接口是不能够直接创建Bean的(动态代理技术来解决)
    @Autowired(required = false)
    private ScoreMapper scoreMapper;
    /*
    * 单元测试方法：可以独立运行，不用启动整个项目，做单元测试，提升效率
    * 1.必须被Test注解修饰
    * 2.返回值类型必须是void
    * 3.方法的参数列表不能指定任何类型
    * 4.方法的访问修饰符必须是public
    * */
    @Test
    public void insert(){
        Score score = new Score();
        score.setSdeno("001");
        score.setSno("3271820613");
        score.setCno("00212");
        score.setGrade(90);
        scoreMapper.insert(score);
    }

    @Test
    public void countBySno(){
        Integer count = scoreMapper.countBySno("3221702938");
        System.out.println(count);
    }

    // 查询一个学号的成绩
    @Test
    public void findScoreBySno(){
       List<Score> scores = scoreMapper.findScoreBySno();
        System.out.println(scores);
    }

    @Test
    public void findVOBySno(){
        System.out.println(scoreMapper.findVOBySno("3221702938"));
    }

    @Test
    public void findAllScores(){
        List<ScoreVO> allScores = scoreMapper.findAllScores();
        System.out.println(allScores);
    }

    /* 删除成绩测试 */
    @Test
    public void deleteScore(){
        Integer result = scoreMapper.deleteScore("3221702938","00212");
        System.out.println(result);
    }

    @Test
    public void findScoreBySnoCno(){
        Score score = scoreMapper.findScoreBySnoCno("3221702938","00214");
        System.out.println(score);
    }

    @Test
    public void findMyScore(){
        List<ScoreVO> list = scoreMapper.findMyScore("3221702950");
        System.out.println(list);
    }

//    @Test
//    public void updateScore(){
//        Integer rows = scoreMapper.updateGrade("3221702938","00220",93);
//        System.out.println(rows);
//    }

    @Test
    public void updateAScore(){
//        Integer rows = scoreMapper.updateGrade("3221702938","00220",93);
        Score score = new Score();
        score.setSno("3221702938");
        score.setCno("00220");
        score.setModifiedUser("管理员");
        score.setGrade(92);
        score.setModifiedTime(new Date());
        Integer rows = scoreMapper.updateAScore(score);
        System.out.println(rows);
    }

    @Test
    public void insertScoresList(){
        List<Score> list = new ArrayList<>();
        Score score1 = new Score();
        score1.setSno("3221702950");
        score1.setCno("11007");
        score1.setGrade(92);
        Score score2 = new Score();
        score2.setSno("3221702950");
        score2.setCno("00220");
        score2.setGrade(94);
        list.add(score1);
        list.add(score2);
        for(Score score:list){
           Integer rows = scoreMapper.insert(score);
            System.out.println(rows);
        }
    }
    
}
