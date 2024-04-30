package com.cy.school1.service;

import com.cy.school1.entity.Course;
import com.cy.school1.service.impl.CourseServiceImpl;
import com.cy.school1.vo.CourseVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.util.Date;
import java.util.List;

@MapperScan("com.cy.school1.mapper")
@SpringBootTest
@RunWith(SpringRunner.class)
public class CourseServiceTests {

    @Autowired
    private ICourseService courseService;

    @Test
    public void findHotList(){
        List<CourseVO> list = courseService.findHotList();
        System.out.println(list);
    }

    @Test
    public void findByCno(){
        Course course = courseService.findByCno("00220");
        System.out.println(course);
    }

    @Test
    public void findNeedList(){
        List<Course> list = courseService.findNeedList();
        System.out.println(list);
    }

    @Test
    public void findTeacherCourse(){
        List<CourseVO> list = courseService.findTeacherCourse("20127186");
        System.out.println(list);
    }

    @Test
    public void insertCourse(){
        Course course = new Course();
        course.setCno("00216");
        course.setCname("数据库");
        course.setTno("12312941");
        course.setCplace("教一301");
        course.setCredit(3);
        course.setCtime(32);
        course.setNeed(0);
//        course.setCreatedUser("50200");
//        course.setCreatedTime(new Date());
//        course.setModifiedUser("50200");
//        course.setModifiedTime(new Date());
        Integer rows = courseService.insertCourse("50200",course);
        System.out.println(rows);
    }

    @Test
    public void findAllCourses(){
        List<CourseVO> list = courseService.findAllCourses();
        System.out.println(list);
    }

    @Test
    public void deleteCourse(){
        Integer rows = courseService.deleteCourse("11111");
        System.out.println(rows);
    }

    @Test
    public void updateCourse(){
        Course course = new Course();
        course.setCno("00212");
        course.setCredit(48);
        Integer rows = courseService.updateCourse(course,"50200");
        System.out.println(rows);
    }
}
