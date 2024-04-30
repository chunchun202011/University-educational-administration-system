package com.cy.school1.service.impl;

import com.cy.school1.entity.*;
import com.cy.school1.mapper.ScoreOrderMapper;
import com.cy.school1.service.*;
import com.cy.school1.service.ex.InsertException;
import com.cy.school1.vo.ScoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class ScoreOrderServiceImpl implements IScoreOrderService {
    @Autowired
    private ScoreOrderMapper scoreOrderMapper;

    @Override
    public ScoreRecord create(String[] snos, String cno, String tno) {

        List<ScoreVO> list = this.getScoreVOBySnos(snos,cno);

        //即将改成绩的列表
        ScoreRecord scoreRecord = new ScoreRecord();
        scoreRecord.setCno(cno);
//        for(String sno :snos){
//            scoreRecord.setSno(sno);
//        }
        scoreRecord.setCreatedUser(tno);
        scoreRecord.setCreatedTime(new Date());
        scoreRecord.setModifiedUser(tno);
        scoreRecord.setModifiedTime(new Date());
        Integer rows = scoreOrderMapper.insertRecord(scoreRecord);
        if (rows != 1){
            throw new InsertException("插入时异常！");
        }

        //创建选课单详细项的信息
        for (ScoreVO scoreVO :list){
            //创建一个选课单项数据对象
            ScoreItem scoreItem = new ScoreItem();
            scoreItem.setSo(scoreRecord.getSr());
            for (String sno : snos){
                scoreItem.setSno(sno);
            }
            scoreItem.setCno(scoreVO.getCno());
            scoreItem.setGrade(scoreVO.getGrade());
            //日志字段
            scoreItem.setCreatedUser(tno);
            scoreItem.setCreatedTime(new Date());
            scoreItem.setModifiedUser(tno);
            scoreItem.setModifiedTime(new Date());
            //插入数据
            scoreOrderMapper.insertScoreItem(scoreItem);
        }
        return scoreRecord;
    }

    @Override
    public List<ScoreVO> findAllScoreOrderItems() {
        List<ScoreVO> scoreVOs = scoreOrderMapper.findAllScoreItems();
        return scoreVOs;
    }

    @Override
    public List<ScoreVO> getScoreVOBySnos(String[] snos,String cno) {
        List<ScoreVO> list = scoreOrderMapper.findScoreVOBySnos(snos);
        Iterator<ScoreVO> it = list.iterator();
        List delList = new ArrayList();
        while (it.hasNext()){
            ScoreVO scoreVO = it.next(); //指向第一个元素之前，要next才能拿到第一个元素
            if (!scoreVO.getCno().equals(cno)){ //表示当前的成绩不属于当前的课程
//                list.remove(scVO);
                delList.add(scoreVO);
            }
        }
        list.removeAll(delList);
        return list;
    }
}
