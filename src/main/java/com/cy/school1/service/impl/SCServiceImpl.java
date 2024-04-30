package com.cy.school1.service.impl;

import com.cy.school1.entity.Course;
import com.cy.school1.entity.SC;
import com.cy.school1.mapper.CourseMapper;
import com.cy.school1.mapper.SCMapper;
import com.cy.school1.service.ISCService;
import com.cy.school1.service.ex.*;
import com.cy.school1.vo.CourseVO;
import com.cy.school1.vo.SCVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class SCServiceImpl implements ISCService {
    /* 选修课车的业务层依赖于课程的持久层 */
    @Autowired
    private SCMapper scMapper;
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public void addToSCCart(String sno, String cno, Integer amount, String sname) {
        //查询当前要添加的数据在表中是否已存在
        SC result = scMapper.findBySnoCno(sno,cno);
        Date date = new Date();
        if (result == null){    //表示这个选课从来没有被添加到课表中，进行新增操作
            //创建一个sc对象
            SC sc = new SC();
            //补全数据
            sc.setSno(sno);
            sc.setCno(cno);
            sc.setTerm(amount);
            // 补全学分：来自课程中的数据
            Course course = courseMapper.findByCno(cno);
            System.out.println(course);
            sc.setCredit(course.getCredit());
//            sc.setTotal(course.getCredit() * sc.getTerm());    //获取单价的数据，乘法运算在选修列表中做
            //补全4日志
            sc.setCreatedUser(sname);
            sc.setCreatedTime(date);
            sc.setModifiedUser(sname);
            sc.setModifiedTime(date);
            //执行输入的插入操作
            Integer rows = scMapper.insert(sc);
            if (rows!=1){
                throw new InsertException("插入数据时产生未知的异常！");
            }
        }else{  // 表示当前的课程在选课表中已存在，则更新数据的term值
            // 进行原有数据和现有传递数据进行相加操作（前端、后端业务层）
            Integer term = result.getTerm() + amount;
            Integer rows = scMapper.updateTermBySnoCno(result.getSno(), result.getCno(),
                                        term,sname, date);
            if(rows!=1){
                throw new UpdateException("更新时异常！");
            }
        }
    }

    @Override
    public List<SCVO> getVOBySno(String sno) {
        return scMapper.findVOBySno(sno);
    }

    @Override
    public Integer addTerm(String cno, String sno, String sname){
        SC result = scMapper.findBySnoCno(sno,cno);
        if (result == null){
            throw new SCNotFoundException("数据不存在");
        }
//        if(result.getSno().equals(sno)){
//            throw new AccessDeniedException("数据非法访问！");
//        }
        Integer term =result.getTerm() + 1;
        Integer rows = scMapper.updateTermBySnoCno(sno,cno,term,sname,new Date());
        if (rows != 1){
            throw new UpdateException("更新数据失败！");
        }
        //返回新的选课列表数据的总量
        return term;
    }

    @Override
    public Integer reduceTerm(String cno, String sno, String sname) {
        SC result = scMapper.findBySnoCno(sno,cno);
        if (result == null){
            throw new SCNotFoundException("数据不存在");
        }
        Integer term =result.getTerm() - 1;
        Integer rows = scMapper.updateTermBySnoCno(sno,cno,term,sname,new Date());
        if (rows != 1){
            throw new UpdateException("更新数据失败！");
        }
        //返回新的选课列表数据的总量
        return term;
    }

    @Override
    public List<SCVO> getVOByCno(String sno, String[] cnos) {
        List<SCVO> list = scMapper.findVOByCno(cnos);
        Iterator<SCVO> it = list.iterator();
        List delList = new ArrayList();
        while (it.hasNext()){
            SCVO scVO = it.next(); //指向第一个元素之前，要next才能拿到第一个元素
            if (!scVO.getSno().equals(sno)){ //表示当前的数据不属于当前的用户
//                list.remove(scVO);
                delList.add(scVO);
            }
        }
        list.removeAll(delList);
        return list;
    }

    @Override
    public void deleteSC(String sno, String cno) {
        Integer rows = scMapper.deleteSC(sno,cno);
        if (rows!=1){
            throw new DeleteException("删除选修课异常！");
        }
    }

    @Override
    public Integer deleteManySCs(String sno, String[] cnos) {
        Integer rows = scMapper.deleteManySCs(sno,cnos);
        if (rows <= 0){
            throw new DeleteException("删除选课失败！");
        }
        System.out.println(rows);
        return rows;
    }

    @Override
    public List<SCVO> findAllStudentsSCs() {
        List<SCVO> scs = scMapper.findAllStudentsSCs();
        return scs;
    }

    @Override
    public SCVO findSC(String sno, String cno) {
        SCVO scvo = scMapper.findSC(sno,cno);
        return scvo;
    }

    @Override
    public int updateSC(String newCno, String sno, String cno,
                        String modifiedUser) {
        int rows = scMapper.updateSC(newCno,sno,cno,modifiedUser,new Date());
        return rows;
    }

    @Override
    public Integer saddSC(String sno, String cno) {
        SC sc = new SC();
        sc.setSno(sno);
        sc.setCno(cno);
        sc.setCreatedUser(sno);
        sc.setCreatedTime(new Date());
        sc.setModifiedUser(sno);
        sc.setModifiedTime(new Date());
        Integer rows = scMapper.addSC(sc);
        return rows;
    }

    @Override
    public Integer maddSC(String mno, String sno,String cno) {
        SC sc = new SC();
        sc.setSno(sno);
        sc.setCno(cno);
        sc.setCreatedUser(mno);
        sc.setCreatedTime(new Date());
        sc.setModifiedUser(mno);
        sc.setModifiedTime(new Date());
        Integer rows = scMapper.addSC(sc);
        return rows;
    }

    @Override
    public List<SCVO> findMyStuSC(String tno) {
        List<SCVO> list = scMapper.findMyStuSC(tno);
        return list;
    }

    @Override
    public List<SCVO> selectByCondition(String tno, String condition,
                                        String key1, String value1,
                                        String key2, String value2) {

        List<SCVO> list =null;
        switch (condition){
            case "and":
                list = scMapper.selectByConditionAnd(tno,key1,value1,key2,value2);
                break;
            case "or":
                list = scMapper.selectByConditionOr(tno,key1,value1,key2,value2);
                break;
            case "not":
                list = scMapper.selectByConditionNot(tno,key1,value1,key2,value2);
                break;
        }
        return list;
    }

    @Override
    public List<SCVO> selectByConditionAnd(String tno, String key1, String value1, String key2, String value2) {
        List<SCVO> list = scMapper.selectByConditionAnd(tno,key1,value1,key2,value2);
        return list;
    }

    @Override
    public List<SCVO> selectByMCondition(String condition, String key1, String value1, String key2, String value2) {
        List<SCVO> list =null;
        switch (condition){
            case "and":
                list = scMapper.selectByConditionMAnd(key1,value1,key2,value2);
                break;
            case "or":
                list = scMapper.selectByConditionMOr(key1,value1,key2,value2);
                break;
            case "not":
                list = scMapper.selectByConditionMNot(key1,value1,key2,value2);
                break;
        }
        return list;
    }


}
