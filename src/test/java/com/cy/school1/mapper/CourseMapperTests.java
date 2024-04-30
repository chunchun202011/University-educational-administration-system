package com.cy.school1.mapper;

import com.cy.school1.entity.Course;
import com.cy.school1.vo.CourseVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CourseMapperTests {

    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void findHotList(){
       List<CourseVO> list =  courseMapper.findHotList();
        System.out.println(list);
    }

    @Test
    public void findByCno(){
        Course course = courseMapper.findByCno("11002");
        System.out.println(course);
    }

    @Test
    public void findNeedList(){
        List<Course> list = courseMapper.findNeedList();
        System.out.println(list);
    }

    @Test
    public void findTeacherCourse(){
        List<CourseVO> list = courseMapper.findTeacherCourse("12312941");
        System.out.println(list);
    }

    @Test
    public void insertCourse(){
        Course course = new Course();
        course.setCno("00215");
        course.setCname("机器学习");
        course.setTno("20127188");
        course.setCredit(3);
        course.setCtime(32);
        course.setNeed(0);
        course.setCreatedUser("张丽");
        course.setCreatedTime(new Date());
        course.setModifiedUser("张丽");
        course.setModifiedTime(new Date());
        Integer rows = courseMapper.insertCourse(course);
        System.out.println(rows);
    }


    @Test
    public void findAllCourses(){
        List<CourseVO> list = courseMapper.findAllCourses();
        System.out.println(list);
    }

    @Test
    public void deleteCourse(){
        Integer rows = courseMapper.deleteCourse("11111");
        System.out.println(rows);
    }


    @Test
    public void updateCourse(){
        Course course  = new Course();
        course.setCno("00212");
        course.setCtime(50);
        Integer rows = courseMapper.updateCourse(course);
        System.out.println(rows);
    }

    @Test
    public void selectByConditionAnd(){
        List<CourseVO> courseVOS = courseMapper.selectByConditionAnd("cno","2","cplace","教");
        System.out.println(courseVOS);
    }

    @Test
    public void selectByConditionOr(){
        List<CourseVO> courseVOS = courseMapper.selectByConditionOr("cno","1","cplace","教");
        System.out.println(courseVOS);
    }

    @Test
    public void selectByConditionNot(){
        List<CourseVO> courseVOS = courseMapper.selectByConditionNot("credit","28","cname","数");
        System.out.println(courseVOS);
    }
}
