package com.cy.school1.controller;


import com.cy.school1.entity.ScoreItem;
import com.cy.school1.entity.WaitScore;
import com.cy.school1.service.IWaitScoreService;
import com.cy.school1.util.JsonResult;
import com.cy.school1.vo.ScoreVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;


@RequestMapping("score")
@RestController
public class WaitScoreController extends BaseController{
    @Autowired
    private IWaitScoreService waitScoreService;

    @RequestMapping("add_to_wait")
    public JsonResult<WaitScore> addToWaitScore(HttpSession session, String cno){
        String tno = getTnoFromSession(session);
        WaitScore data = waitScoreService.addToWaitScore(tno,cno);
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("create")
    public JsonResult<Void> create(HttpSession session, String cno,@RequestBody List<ScoreItem> scoreItems){
        String tno = getTnoFromSession(session);
        waitScoreService.create(tno,cno,scoreItems);
        return new JsonResult<>(OK);
    }

    @RequestMapping("create_one")
    public JsonResult<Void> create_one(HttpSession session,String cno,String sno,Integer grade){
        String tno = getTnoFromSession(session);
        waitScoreService.createOne(tno,cno,sno,grade);
        return new JsonResult<>(OK);
    }

    @RequestMapping("all")
    public JsonResult<List<ScoreVO>> findAllScores(){
        List<ScoreVO> data = waitScoreService.findAllScores();
        return new JsonResult<List<ScoreVO>>(OK,data);
    }

    @RequestMapping("tall")
    public JsonResult<List<ScoreVO>> findTStuScore(HttpSession session){
        String tno = getTnoFromSession(session);
        List<ScoreVO> data = waitScoreService.findTStuScore(tno);
        return new JsonResult<List<ScoreVO>>(OK,data);
    }

    @RequestMapping("update")
    public JsonResult<Void> updateScoreItem(HttpSession session,String sno,String cno,Integer grade){
        String tno = getTnoFromSession(session);
        Integer rows = waitScoreService.updateScoreItem(tno,sno,cno,grade);
        return new JsonResult<>(OK);
    }

    @RequestMapping("delete")
    public JsonResult<Void> deleteScoreItem(String sno,String cno){
        Integer rows = waitScoreService.deleteScoreItem(sno,cno);
        return new JsonResult<>(OK);
    }

    @RequestMapping("select_and")
    public JsonResult<List> selectByConditionAnd(@Param("key1")String key1, @Param("value1")String value1,
                                              @Param("key2")String key2, @Param("value2")String value2){
        List<ScoreVO> data = waitScoreService.selectByConditionAnd(key1,value1,key2,value2);
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("myScore")
    public JsonResult<List<ScoreVO>> findMyScore(HttpSession session){
        String sno = getSnoFromSession(session);
        List<ScoreVO> data = waitScoreService.findMyScore(sno);
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("myAddScore")
    public JsonResult<List<ScoreVO>> findMyAddScore(HttpSession session){
        String tno = getTnoFromSession(session);
        List<ScoreVO> data = waitScoreService.findMyAddScore(tno);
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("select_tand")
    public JsonResult<List> selectByConditionTAnd(HttpSession session,
            @Param("key1")String key1, @Param("value1")String value1,
             @Param("key2")String key2, @Param("value2")String value2){
        String tno = getTnoFromSession(session);
        List<ScoreVO> data = waitScoreService.selectByConditionTAnd(tno,key1,value1,key2,value2);
        return new JsonResult<>(OK,data);
    }

}
