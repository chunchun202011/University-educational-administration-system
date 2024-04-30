package com.cy.school1.mapper;

import com.cy.school1.entity.Manager;
import com.cy.school1.entity.Student;
import com.cy.school1.entity.Teacher;
import com.cy.school1.vo.StudentSelectVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @SpringBootTest:表示标注当前的类是一个测试类，不会随同项目一块打包发送

@SpringBootTest

// @RunWith:表示启动这个单元测试类(单元测试类是不能运行的)，需要传递一个参数，必须是SpringRunner的实例类型
@RunWith(SpringRunner.class)
public class UserMapperTests {

    //idea有检测的功能，接口是不能够直接创建Bean的(动态代理技术来解决)
    @Autowired(required = false)
    private UserMapper userMapper;
    /*
    * 单元测试方法：可以独立运行，不用启动整个项目，做单元测试，提升效率
    * 1.必须被Test注解修饰
    * 2.返回值类型必须是void
    * 3.方法的参数列表不能指定任何类型
    * 4.方法的访问修饰符必须是public
    * */

    @Test
    public void insert(){
        Student student = new Student();
        student.setSno("123");
        student.setSname("张年");
        student.setPassword("123");
        student.setIsDelete(0);
        student.setCreatedUser("管理员");
        student.setCreatedTime(new Date());
        student.setModifiedUser("管理员");
        student.setModifiedTime(new Date());
        Integer rows = userMapper.insert(student);
        System.out.println(rows);
    }

    @Test
    public void findBySno(){
        Student student = userMapper.findBySno("3221702938");
        System.out.println(student);
    }

    @Test
    public void updatePasswordBySno(){
        userMapper.updatePasswordBySno(
                "3221702938","3221702938",
                "管理员",new Date());
    }

    @Test
    public void updateInfoBySno(){
        Student student = new Student();
        student.setSno("3271821624");
        student.setPhone("1324768137");
        student.setEmail("test2@qq.com");
        student.setGender(0);
        userMapper.updateInfoBySno(student);
    }

    @Test
    public void updateAvatarBySno(){
        userMapper.updateAvatarBySno("3271821624",
                "/upload/avatar.png",
                "管理员",
                new Date());
    }


    @Test
    public void insertT(){
//        Student student = new Student();
//        student.setSno("3221702938");
//        student.setSname("林木");
//        student.setPassword("3221702938");
//        Integer rows = userMapper.insert(student);
        Teacher teacher = new Teacher();
        teacher.setTno("20127181");
        teacher.setTname("张强");
        teacher.setPassword("20127181");
        Integer rows = userMapper.insertT(teacher);
        System.out.println(rows);
    }

    @Test
    public void findByTno(){
        Teacher teacher = userMapper.findByTno("20127181");
        System.out.println(teacher);
    }


    @Test
    public void findByMno(){
        Manager manager = userMapper.findByMno("50200");
        System.out.println(manager);
    }

    @Test
    public void selectByCondition1(){
//        Student student = new Student();
//        student.setSno("3");
//        student.setSname("林");
//        student.setGender(1);
//        List list = userMapper.selectByConditionAnd(student);
        List<Student> list = userMapper.selectByConditionAnd("sno","32","email","qq");
        List<Student> list1 = userMapper.selectByConditionOr("sno","32","sname","林木");
        List<Student> list2 = userMapper.selectByConditionNot("sno","32","sname","林木");
        System.out.println("And查询结果：");
        System.out.println(list);
        System.out.println("Or查询结果：");
        System.out.println(list1);
        System.out.println("Not查询结果：");
        System.out.println(list2);
    }

//    @Test
//    public void selectByConditionOr(){
//        Student student = new Student();
//        student.setSno("3221702938");
//        student.setSname("林");
//        student.setGender(1);
//        List list = userMapper.selectByConditionOr(student);
//        System.out.println(list);
//    }
//
//    @Test
//    public void selectByConditionNot(){
//        Student student = new Student();
//        student.setSno("3221702938");
//        student.setSname("林");
//        student.setGender(1);
//        List list = userMapper.selectByConditionNot(student);
//        System.out.println(list);
//    }

    @Test
    public void selectMyStudent(){
        List list = userMapper.selectMyStudent("20127186");
        System.out.println(list);
    }

    @Test
    public void findAllTeachers(){
        List<Teacher> list = userMapper.findAllTeachers();
        System.out.println(list);
    }

    @Test
    public void deleteFalseBySno(){
        userMapper.deleteFalseBySno("3221701234");
    }

    @Test
    public void notScoreStudent(){
        List<Student> list = userMapper.notScoreStudent("10212");
        System.out.println(list);
    }


}
