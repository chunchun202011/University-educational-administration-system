package com.cy.school1.controller;

import com.cy.school1.service.ISCService;
import com.cy.school1.util.JsonResult;
import com.cy.school1.vo.CourseVO;
import com.cy.school1.vo.SCVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.nio.file.AccessDeniedException;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RequestMapping("scs")
@RestController
public class SCController extends BaseController{
    @Autowired
    private ISCService scService;

    @RequestMapping({"","/"})
    public JsonResult<List<SCVO>> getVOBySno(HttpSession session){
        List<SCVO> data = scService.getVOBySno(getSnoFromSession(session));
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("add_sc")
    public JsonResult<Void> addToSCCart(String cno,
                                        Integer term,
                                        HttpSession session){
        scService.addToSCCart(getSnoFromSession(session),
                                cno,term,
                                getSnameFromSession(session));
        return new JsonResult<>(OK);
    }


    @RequestMapping("{cno}/term/add")
    public JsonResult<Integer> addTerm(@PathVariable("cno") String cno,HttpSession session) {
        Integer data = scService.addTerm(cno,
                getSnoFromSession(session),getSnameFromSession(session));
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("{cno}/term/reduce")
    public JsonResult<Integer> reduceTerm(@PathVariable("cno") String cno,HttpSession session) {
        Integer data = scService.reduceTerm(cno,
                getSnoFromSession(session),getSnameFromSession(session));
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("list")
    public JsonResult<List<SCVO>> getVOByCno(String[] cnos,HttpSession session){
        List<SCVO> data = scService.getVOByCno(getSnoFromSession(session),
                                                cnos);
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("delete")
    public JsonResult<Void> deleteSC(String cno,HttpSession session){
        String sno = getSnoFromSession(session);
        scService.deleteSC(sno,cno);
        return new JsonResult<>(OK);
    }

    @RequestMapping("delete_many")
    public JsonResult<Void> deleteManySCs(HttpSession session,String[] cnos){
        String sno = getSnoFromSession(session);
        scService.deleteManySCs(sno,cnos);
        return new JsonResult<>(OK);
    }

    @RequestMapping("allstu")
    public JsonResult<List<SCVO>> findAllStudentsSCs(){
        List<SCVO> data = scService.findAllStudentsSCs();
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("find")
    public JsonResult<SCVO> findSC(String sno,String cno){
        SCVO data = scService.findSC(sno,cno);
        return new JsonResult<SCVO>(OK,data);
    }

    @RequestMapping("update")
    public JsonResult<Void> updateSC(@Param("newCno") String newCno, @Param("sno") String sno,
                                     @Param("cno") String cno, HttpSession session){
        String modifiedUser = getMnoFromSession(session);
        int rows = scService.updateSC(newCno,sno,cno,modifiedUser);
        return new JsonResult<>(OK);
    }

    @RequestMapping("deleteStuSC")
    public JsonResult<Void> deleteStuSC(String sno,String cno){
        scService.deleteSC(sno,cno);
        return new JsonResult<>(OK);
    }

    @RequestMapping("sadd")
    public JsonResult<Integer> addSC(HttpSession session,String cno){
        String sno = getSnoFromSession(session);
        Integer data = scService.saddSC(sno,cno);
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("madd")
    public JsonResult<Integer> maddSC(HttpSession session,String sno,String cno){
        String mno = getMnoFromSession(session);
        Integer data = scService.maddSC(mno,sno,cno);
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("mySC")
    public JsonResult<List<SCVO>> mySC(HttpSession session){
        String sno = getSnoFromSession(session);
        List<SCVO> data = scService.getVOBySno(sno);
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("myStuSC")
    public JsonResult<List<SCVO>> myStuSC(HttpSession session){
        String tno = getTnoFromSession(session);
        List<SCVO> data = scService.findMyStuSC(tno);
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("select_condition")
    public JsonResult<List> selectByCondition(
            HttpSession session,String condition,
            @Param("key1")String key1,@Param("value1")String value1,
              @Param("key2")String key2,@Param("value2")String value2){
        String tno = getTnoFromSession(session);
        List<SCVO> data = scService.selectByCondition(tno,condition,key1,value1,key2,value2);
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("select_con_and")
    public JsonResult<List> selectByConditionAnd(
            HttpSession session,
            @Param("key1")String key1,@Param("value1")String value1,
            @Param("key2")String key2,@Param("value2")String value2){
        String tno = getTnoFromSession(session);
        List<SCVO> data = scService.selectByConditionAnd(tno,key1,value1,key2,value2);
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("select_con_mand")
    public JsonResult<List> selectByConditionMAnd(String condition,
            @Param("key1")String key1,@Param("value1")String value1,
            @Param("key2")String key2,@Param("value2")String value2){
        List<SCVO> data = scService.selectByMCondition(condition,key1,value1,key2,value2);
        return new JsonResult<>(OK,data);
    }


}
