package com.cy.school1.service.impl;

import com.cy.school1.entity.*;
import com.cy.school1.mapper.*;
import com.cy.school1.service.IScoreOrderService;
import com.cy.school1.service.IWaitScoreService;
import com.cy.school1.service.ex.DeleteException;
import com.cy.school1.service.ex.InsertException;
import com.cy.school1.service.ex.UpdateException;
import com.cy.school1.vo.CourseVO;
import com.cy.school1.vo.SCVO;
import com.cy.school1.vo.ScoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class WaitScoreServiceImpl implements IWaitScoreService {
    @Autowired
    private WaitScoreMapper waitScoreMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ScoreMapper scoreMapper;


    @Override
    public WaitScore addToWaitScore(String tno, String cno) {
        //查询要添加的课程的成绩是否在表中存在
        WaitScore result = waitScoreMapper.findWaitScoreByCno(cno);
        if(result == null){
            // 创建一个waitScore对象
            WaitScore waitScore = new WaitScore();
            waitScore.setCno(cno);
            waitScore.setIsDelete(0);
            //补全日志
            waitScore.setCreatedUser(tno);
            waitScore.setCreatedTime(new Date());
            waitScore.setModifiedUser(tno);
            waitScore.setModifiedTime(new Date());
            Integer rows = waitScoreMapper.insertWaitScore(waitScore);
            if (rows!=1){
                throw new InsertException("插入数据时产生未知异常！");
            }
        }
        return result;
    }

    @Override
    public void create(String tno, String cno, List<ScoreItem> scoreItems) {
        //成绩记录单数据
        WaitScore waitScore = new WaitScore();
        waitScore.setCno(cno);
        waitScore.setIsDelete(0);
        //日志
        waitScore.setCreatedUser(tno);
        waitScore.setCreatedTime(new Date());
        waitScore.setModifiedUser(tno);
        waitScore.setModifiedTime(new Date());
        //插入数据
        Integer rows = waitScoreMapper.insertWaitScore(waitScore);
        if (rows != 1){
            throw new InsertException("插入时异常！");
        }
//        WaitScore waitScore1 = waitScoreMapper.findWaitScoreByCno(cno);
        Integer wid = waitScore.getWid();

        //创建成绩单详细项的信息
        // 创建VO类，包含它的要插入的所有信息
        for (ScoreItem scoreItem :scoreItems){
            //创建一个成绩单项数据对象
            ScoreItem insert  = new ScoreItem();
            insert.setSr(wid);
            insert.setSno(scoreItem.getSno());
            insert.setCno(cno);
            insert.setGrade(scoreItem.getGrade());
            //日志字段
            insert.setCreatedUser(tno);
            insert.setCreatedTime(new Date());
            insert.setModifiedUser(tno);
            insert.setModifiedTime(new Date());
            //插入数据
            waitScoreMapper.insertScoreItem(insert);
        }
    }

    @Override
    public void createOne(String tno, String cno, String sno,Integer grade) {
        //成绩记录单数据
        WaitScore waitScore = new WaitScore();
        waitScore.setCno(cno);
        waitScore.setIsDelete(0);
        //日志
        waitScore.setCreatedUser(tno);
        waitScore.setCreatedTime(new Date());
        waitScore.setModifiedUser(tno);
        waitScore.setModifiedTime(new Date());
        //插入数据
        Integer rows = waitScoreMapper.insertWaitScore(waitScore);
        if (rows != 1){
            throw new InsertException("插入时异常！");
        }
//        WaitScore waitScore1 = waitScoreMapper.findWaitScoreByCno(cno);
        Integer wid = waitScore.getWid();
        //插入成绩单
        ScoreItem scoreItem = new ScoreItem();
        scoreItem.setSno(sno);
        scoreItem.setCno(cno);
        scoreItem.setGrade(grade);
        scoreItem.setSr(wid);
        scoreItem.setCreatedUser(tno);
        scoreItem.setCreatedTime(new Date());
        scoreItem.setModifiedUser(tno);
        scoreItem.setModifiedTime(new Date());
        Integer rows1 = waitScoreMapper.insertScoreItem(scoreItem);
        if (rows1 <= 0){
            throw new InsertException("插入成绩异常！");
        }
    }

    @Override
    public List<ScoreVO> findAllScores() {
        List<ScoreVO> scores = waitScoreMapper.findAllScores();
        return scores;
    }

    @Override
    public List<ScoreVO> findTStuScore(String tno) {
        List<ScoreVO> scores = waitScoreMapper.findTStuScore(tno);
        return scores;
    }

    @Override
    public Integer updateScoreItem(String tno, String sno,String cno,Integer grade) {
        ScoreItem scoreItem = waitScoreMapper.findScoreItemBySnoCno(sno,cno);
        scoreItem.setGrade(grade);
        scoreItem.setModifiedUser(tno);
        scoreItem.setModifiedTime(new Date());
        Integer rows = waitScoreMapper.updateAScoreItem(scoreItem);
        if (rows<=0){
            throw new UpdateException("更新成绩产生异常！");
        }
        return rows;
    }

    @Override
    public Integer deleteScoreItem(String sno, String cno) {
        Integer rows = waitScoreMapper.deleteScoreItem(sno,cno);
        if (rows <=0){
            throw new DeleteException("删除成绩异常！");
        }
        return rows;
    }

    @Override
    public List<ScoreVO> selectByConditionAnd(String key1, String value1,
                                               String key2, String value2) {
        List<ScoreVO> scores = waitScoreMapper.selectByConditionAnd(key1,value1,key2,value2);
        return scores;
    }

    @Override
    public List<ScoreVO> findMyScore(String sno) {
        List<ScoreVO> list = scoreMapper.findMyScore(sno);
        return list;
    }

    @Override
    public List<ScoreVO> findMyAddScore(String tno) {
        List<ScoreVO> list = waitScoreMapper.findMyAddScore(tno);
        return list;
    }

    @Override
    public List<ScoreVO> selectByConditionTAnd(String tno, String key1, String value1, String key2, String value2) {
        List<ScoreVO> list = waitScoreMapper.selectByConditionTAnd(tno,key1,value1,key2,value2);
        return list;
    }

}
