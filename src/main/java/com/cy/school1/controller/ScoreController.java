package com.cy.school1.controller;

import com.cy.school1.entity.Score;
import com.cy.school1.service.IScoreService;
import com.cy.school1.util.JsonResult;
import com.cy.school1.vo.ScoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("scores")
@RestController
public class ScoreController extends BaseController {
    @Autowired
    private IScoreService scoreService;

//    @RequestMapping("add_new_score")
//    public JsonResult<Void> addNewScore(String sno,Integer grade, HttpSession session){
//        // 注：session对象是已登录用户的信息
//        // 要登录教师账户才能修改(tno)
//        String tno = getTnoFromSession(session);
//        scoreService.addNewScore(sno,tno,grade);
//        return new JsonResult<>(OK);
//    }

    @RequestMapping("add_new_score")
    public JsonResult<Void> addNewScore(String sno,String cno,
                                        Score score, HttpSession session){
        // 注：session对象是已登录用户的信息
        // 要登录教师账户才能修改(tno)
        String tno = getTnoFromSession(session);
        scoreService.addNewScore(sno,cno,tno,score);
        return new JsonResult<>(OK);
    }

    /* 查询自己的成绩 */
    @RequestMapping("view_my_score")
    public JsonResult<List<ScoreVO>> getVOBySno(HttpSession session){
        // 注：session对象是已登录用户的信息
        List<ScoreVO> data =  scoreService.getVOBySno(getSnoFromSession(session));
        return new JsonResult<>(OK,data);
    }

    /* 查询所有学生的成绩 */
    @RequestMapping("view_all_scores")
    public JsonResult<List<ScoreVO>> findAllScores(){
        // 注：session对象是已登录用户的信息
        List<ScoreVO> data =  scoreService.findAllScores();
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("{sno}/{cno}/delete")
    public JsonResult<Void> delete(@PathVariable("sno") String sno,
                                   @PathVariable("cno") String cno){
//    public JsonResult<Void> delete(String sno, String cno){
        scoreService.deleteScore(sno,cno);
        return new JsonResult<>(OK);
    }

    @RequestMapping("my_score")
    public JsonResult<List<ScoreVO>> findMyScore(HttpSession session){
        // 注：session对象是已登录用户的信息
        // 要登录教师账户才能修改(tno)
        String sno = getSnoFromSession(session);
        List<ScoreVO> data = scoreService.findMyScore(sno);
        return new JsonResult<>(OK,data);
    }


    @RequestMapping("update")
    public JsonResult<List<ScoreVO>> updateAScore(String sno,String cno,
                                                  Integer grade,
                                                  HttpSession session){
        // 注：session对象是已登录用户的信息
        // 要登录教师账户才能修改(tno)
        String tno = getTnoFromSession(session);
        Integer rows = scoreService.updateAScore(sno,cno,grade,tno);
        return new JsonResult<>(OK);
    }
}
