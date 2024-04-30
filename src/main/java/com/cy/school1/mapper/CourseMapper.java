package com.cy.school1.mapper;

import com.cy.school1.entity.Course;
import com.cy.school1.entity.Student;
import com.cy.school1.vo.CourseVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {

    Integer insertCourse(Course course);

    List<CourseVO> findHotList();

    Course findByCno(String cno);

    CourseVO findVOByCno(String cno);

    List<Course> findNeedList();

    List<CourseVO> findTeacherCourse(String tno);

    List<CourseVO> findAllCourses();

    /**
     * 根据课程号删除课程
     * @param cno
     * @return
     */
    Integer deleteCourse(String cno);

    //修改功能
    int updateCourse(Course course);

    //三个条件查询所有课程
    List<CourseVO> selectByConditionAnd(@Param("key1") String key1, @Param("value1") String value1,
                                       @Param("key2") String key2, @Param("value2") String value2);

    List<CourseVO> selectByConditionOr(@Param("key1") String key1,@Param("value1") String value1,
                                      @Param("key2") String key2,@Param("value2") String value2);
    List<CourseVO> selectByConditionNot(@Param("key1") String key1,@Param("value1") String value1,
                                       @Param("key2") String key2,@Param("value2") String value2);

    CourseVO findSCByCno(String cno);
}
