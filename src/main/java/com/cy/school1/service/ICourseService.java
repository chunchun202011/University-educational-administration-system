package com.cy.school1.service;

import com.cy.school1.entity.Course;
import com.cy.school1.entity.Student;
import com.cy.school1.vo.CourseVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICourseService {
    List<CourseVO> findHotList();

    Course findByCno(String cno);

    List<Course> findNeedList();

    List<CourseVO> findTeacherCourse(String tno);

    Integer insertCourse(String mno,Course course);

    List<CourseVO> findAllCourses();

    Integer deleteCourse(String cno);

    Integer updateCourse(Course course,String mno);

    //三种条件查询
    List<CourseVO> selectByCondition(@Param("condition") String condition,
                                    @Param("key1") String key1, @Param("value1") String value1,
                                    @Param("key2") String key2, @Param("value2") String value2);

    CourseVO findSCdetail(String cno);

    CourseVO findVOByCno(String cno);
}
