package com.cy.school1.service.impl;

import com.cy.school1.entity.Course;
import com.cy.school1.entity.Student;
import com.cy.school1.mapper.CourseMapper;
import com.cy.school1.service.ICourseService;
import com.cy.school1.service.ex.CourseNotFoundException;
import com.cy.school1.service.ex.InsertException;
import com.cy.school1.vo.CourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
/* 展示热门选修课 */
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<CourseVO> findHotList() {
        // 展示前5个热门选修课程
        List<CourseVO> list = courseMapper.findHotList();
        return list;
    }

    @Override
    public Course findByCno(String cno) {
        Course course = courseMapper.findByCno(cno);
        if (course == null){
            throw new CourseNotFoundException("课程数据不存在！");
        }
        return course;
    }

    @Override
    public List<Course> findNeedList() {
        List<Course> list = courseMapper.findNeedList();
        return list;
    }

    @Override
    public List<CourseVO> findTeacherCourse(String tno) {
        List<CourseVO> list = courseMapper.findTeacherCourse(tno);
        return list;
    }

    @Override
    public Integer insertCourse(String mno,Course course) {
        Course course1 = new Course();
        course1.setCno(course.getCno());
        course1.setCname(course.getCname());
        course1.setTno(course.getTno());
        course1.setCredit(course.getCredit());
        course1.setCplace(course.getCplace());
        course1.setCtime(course.getCtime());
        course1.setNeed(course.getNeed());
        course1.setDetail(course.getDetail());
        course1.setCreatedUser(mno);
        course1.setCreatedTime(new Date());
        course1.setModifiedUser(mno);
        course1.setModifiedTime(new Date());
        Integer rows = courseMapper.insertCourse(course1);
        if (rows <= 0){
            throw new InsertException("插入新课程失败！");
        }
        return rows;
    }

    @Override
    public List<CourseVO> findAllCourses() {
        List<CourseVO> list = courseMapper.findAllCourses();
        return list;
    }

    @Override
    public Integer deleteCourse(String cno) {
        Integer rows = courseMapper.deleteCourse(cno);
        if (rows<=0){
            throw new InsertException("删除课程异常！");
        }
        return rows;
    }

    @Override
    public Integer updateCourse(Course course, String mno) {
        course.setModifiedUser(mno);
        course.setModifiedTime(new Date());
        Integer rows = courseMapper.updateCourse(course);
        return rows;
    }

    @Override
    public List<CourseVO> selectByCondition(String condition, String key1, String value1, String key2, String value2) {
        List<CourseVO> list =null;
        switch (condition){
            case "and":
                list = courseMapper.selectByConditionAnd(key1,value1,key2,value2);
                break;
            case "or":
                list = courseMapper.selectByConditionOr(key1,value1,key2,value2);
                break;
            case "not":
                list = courseMapper.selectByConditionNot(key1,value1,key2,value2);
                break;
        }
        return list;
    }

    @Override
    public CourseVO findSCdetail(String cno) {
        CourseVO courseVO = courseMapper.findSCByCno(cno);
        return courseVO;
    }

    @Override
    public CourseVO findVOByCno(String cno) {
        CourseVO courseVO = courseMapper.findVOByCno(cno);
        return courseVO;
    }
}
