package com.cy.school1.mapper;

import com.cy.school1.entity.Course;
import com.cy.school1.entity.SC;
import com.cy.school1.entity.Score;
import com.cy.school1.vo.SCVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SCMapperTests {

    @Autowired
    private SCMapper scMapper;

    @Test
    public void insert(){
        SC sc = new SC();
        sc.setSno("3221702938");
        sc.setCno("11006");
        sc.setTerm(1);
        sc.setCredit(2);
        sc.setTotal(2);
        scMapper.insert(sc);
    }

    @Test
    public void updateTermBySnoCno(){
        scMapper.updateTermBySnoCno("3221702938","00212",1,"管理员",new Date());
    }

    @Test
    public void findBySnoCno(){
        SC sc = scMapper.findBySnoCno("3221702938","11002");
        System.out.println(sc);
    }

    @Test
    public void findVOBySno(){
        System.out.println(scMapper.findVOBySno("3221702938"));
    }

//    @Test
//    public void findByCno(){
//        System.out.println(scMapper.findByCno("11002"));
//    }

    @Test
    public void findVOByCno(){
        String[] cnos = {"11005","11002"};
        System.out.println(scMapper.findVOByCno(cnos));
    }

    @Test
    public void deleteSC(){
        Integer rows =  scMapper.deleteSC("3221702938","11001");
        System.out.println(rows);
    }

    @Test
    public void deleteManySCs(){
        String[] cnos = {"11001","11002"};
        Integer rows =  scMapper.deleteManySCs("3221702938",cnos);
        System.out.println(rows);
    }


    @Test
    public void findAllStudentSCs(){
        List<SCVO> scs = scMapper.findAllStudentsSCs();
        System.out.println(scs);
    }

    @Test
    public void findSC(){
       SCVO scvo = scMapper.findSC("1243123111","21005");
        System.out.println(scvo);
    }

    @Test
    public void updateSC(){
//        SC sc = new SC();
//        sc.setNewCno("124");
//        sc.setSno("11111");
//        sc.setCno("122");
//        sc.setModifiedUser("管理员");
//        sc.setModifiedTime(new Date());
        int rows = scMapper.updateSC("124","11111","123","管理员",new Date());
        System.out.println(rows);
    }

    @Test
    public void addSC(){
        SC sc = new SC();
        sc.setSno("3221702938");
        sc.setCno("11006");
        sc.setCreatedUser("管理员");
        Integer rows = scMapper.addSC(sc);
        System.out.println(rows);
    }

    @Test
    public void findMyStuSC(){
        List<SCVO> scs = scMapper.findMyStuSC("12312941");
        System.out.println(scs);
    }

    @Test
    public void selectByConditionAnd(){
        List<SCVO> scs = scMapper.selectByConditionAnd("12312941","sno","50","sname","元");
        System.out.println(scs);
    }

    @Test
    public void selectByConditionOr(){
        List<SCVO> scs = scMapper.selectByConditionOr("12312941","sno","50","sname","元");
        System.out.println(scs);
    }

    @Test
    public void selectByConditionNot(){
        List<SCVO> scs = scMapper.selectByConditionNot("12312941","sno","50","sname","元");
        System.out.println(scs);
    }

    @Test
    public void selectByConditionMAnd(){
        List<SCVO> scs = scMapper.selectByConditionMAnd("sno","38","sname","林");
        System.out.println(scs);
    }

    @Test
    public void selectByConditionMOr(){
        List<SCVO> scs = scMapper.selectByConditionMOr("sno","38","sname","林");
        System.out.println(scs);
    }

}
