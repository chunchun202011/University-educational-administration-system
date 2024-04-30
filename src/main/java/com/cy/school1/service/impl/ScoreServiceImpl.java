package com.cy.school1.service.impl;

import com.cy.school1.entity.Score;
import com.cy.school1.mapper.ScoreMapper;
import com.cy.school1.service.ICourseService;
import com.cy.school1.service.IScoreService;
import com.cy.school1.service.ISdeptService;
import com.cy.school1.service.ex.*;
import com.cy.school1.vo.ScoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/* 新增收货地址的实现类 */
@Service
public class ScoreServiceImpl implements IScoreService {
    @Autowired(required = false)
    private ScoreMapper scoreMapper;

    //在添加成绩的业务层依赖于ISdeptService的业务层接口
    //将sdeptService获取的专业数据转移到score对象，这个对象就包含了所有用户专业的数据
    @Autowired
    private ISdeptService sdeptService;

    @Autowired
    private ICourseService courseService;

    @Value("${student.score.max-count}")
    private Integer maxCount;
//    @Override
//    public void addNewScore(String sno,String tno,Score score) {
//        //调用成绩数据统计的方法
//        Integer count = scoreMapper.countBySno(sno);
//        if (count > maxCount) {
//            throw new ScoreCountLimitException("添加成绩数目超出上限！");
//        }
//
//        // sno
//        score.setSno(sno);
//
//        //补全4项日志
//        score.setCreatedUser(tno);
//        score.setModifiedUser(tno);
//        score.setModifiedTime(new Date());
//        score.setCreatedTime(new Date());
//
//        //插入成绩的方法
//        Integer rows = scoreMapper.insert(score);
//        if (rows != 1){
//            throw new InsertException("插入成绩数据产生未知异常");
//        }
//    }

//    @Override
//    public void addNewScore(String sno,String tno,Integer grade) {
//        //调用成绩数据统计的方法
//        Integer count = scoreMapper.countBySno(sno);
//        if (count > maxCount) {
//            throw new ScoreCountLimitException("添加成绩数目超出上限！");
//        }
//        Score score = new Score();
//
//        // sno
//        score.setSno(sno);
//        score.setGrade(grade);
//
//        //补全4项日志
//        score.setCreatedUser(tno);
//        score.setModifiedUser(tno);
//        score.setModifiedTime(new Date());
//        score.setCreatedTime(new Date());
//
//        //插入成绩的方法
//        Integer rows = scoreMapper.insert(score);
//        if (rows != 1){
//            throw new InsertException("插入成绩数据产生未知异常");
//        }
//    }
    @Override
    public void addNewScore(String sno,String cno,String tno,Score score) {
        //调用成绩数据统计的方法
        Integer count = scoreMapper.countBySno(sno);
        if (count > maxCount) {
            throw new ScoreCountLimitException("添加成绩数目超出上限！");
        }

        //对sdept对象中的数据进行补全
        //前端传sdeno的数据
        String sdept = sdeptService.getNameBySid(score.getSdeno());
        score.setSdept(sdept);

        // sno
        score.setSno(sno);
//        score.setGrade(grade);
//        String cno = courseService.findByCno(score.getCno());
        //cno
        score.setCno(cno);

        //补全4项日志
        score.setCreatedUser(tno);
        score.setModifiedUser(tno);
        score.setModifiedTime(new Date());
        score.setCreatedTime(new Date());

        //插入成绩的方法
        Integer rows = scoreMapper.insert(score);
        if (rows != 1){
            throw new InsertException("插入成绩数据产生未知异常");
        }
    }

    @Override
    public List<ScoreVO> getVOBySno(String sno) {
        return scoreMapper.findVOBySno(sno);
    }

    @Override
    public List<ScoreVO> findAllScores() {
        List<ScoreVO> scores = scoreMapper.findAllScores();
        return scores;
    }

    @Override
    public void deleteScore(String sno, String cno) {
        Score result = scoreMapper.findScoreBySnoCno(sno,cno);
        if (result == null){
            throw new ScoreNotFoundException("成绩数据不存在！");
        }
        Integer rows = scoreMapper.deleteScore(sno,cno);
        if (rows != 1){
            throw new DeleteException("删除数据产生未知的异常！");
        }
    }

    @Override
    public Score findScoreBySnoCno(String sno, String cno) {
        Score result = scoreMapper.findScoreBySnoCno(sno,cno);
        if (result == null){
            throw new ScoreNotFoundException("成绩数据不存在！");
        }
        return result;
    }

    @Override
    public List<ScoreVO> findMyScore(String sno) {
        List<ScoreVO> list = scoreMapper.findMyScore(sno);
        return list;
    }

    @Override
    public Integer updateAScore(String sno,String cno,Integer grade,String tno) {
        Score score = new Score();
        score.setSno(sno);
        score.setCno(cno);
        score.setGrade(grade);
        score.setModifiedUser(tno);
        score.setModifiedTime(new Date());
        Integer rows = scoreMapper.updateAScore(score);
        if (rows!= 1){
            throw new UpdateException("更新成绩数据失败！");
        }
        return rows;
    }



//    @Override
//    public Integer updateScore(String sno, String cno, Integer grade,String tno) {
//        Score score =  scoreMapper.findScoreBySnoCno(sno,cno);
//        if (score == null){
//            throw new ScoreNotFoundException("查找不到该学生成绩！");
//        }
//        Integer rows = scoreMapper.updateGrade(sno,cno,grade);
//        if (rows != 1){
//            throw new UpdateException("更新学生数据失败！");
//        }
//        score.setModifiedUser(tno);
//        score.setModifiedTime(new Date());
//        Integer inRows = scoreMapper.insert(score);
//        return rows;
//    }
}
