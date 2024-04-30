package com.cy.school1.controller;

import com.cy.school1.entity.Course;
import com.cy.school1.entity.Student;
import com.cy.school1.service.ICourseService;
import com.cy.school1.util.JsonResult;
import com.cy.school1.vo.CourseVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("courses")
public class CourseController extends BaseController{
    @Autowired(required = false)
    private ICourseService courseService;

    @RequestMapping("hot-list")
    public JsonResult<List<CourseVO>> getHotList(){
        List<CourseVO> data = courseService.findHotList();
        return new JsonResult<List<CourseVO>>(OK,data);
    }

    @RequestMapping("{cno}/details")
    public JsonResult<Course> findByCno(@PathVariable("cno") String cno){
        //调用业务对象执行获取数据
        Course data = courseService.findByCno(cno);
        //返回成功和数据
        return new JsonResult<Course>(OK,data);
    }

    @RequestMapping("{cno}/scdetail")
    public JsonResult<CourseVO> findSCDetial(@PathVariable("cno") String cno){
        //调用业务对象执行获取数据
        CourseVO data = courseService.findSCdetail(cno);
        //返回成功和数据
        return new JsonResult<CourseVO>(OK,data);
    }

    @RequestMapping("need-list")
    public JsonResult<List<Course>> getNeedList(){
        List<Course> data = courseService.findNeedList();
        return new JsonResult<List<Course>>(OK,data);
    }

    @RequestMapping("teacher")
    public JsonResult<List<CourseVO>> getTeacherCourse(HttpSession session){
        List<CourseVO> data = courseService.findTeacherCourse(getTnoFromSession(session));
        return new JsonResult<List<CourseVO>>(OK,data);
    }

    @RequestMapping("insert")
    public JsonResult<Integer> insertCourse(HttpSession session,Course course){
       Integer rows = courseService.insertCourse(getMnoFromSession(session),course);
       return new JsonResult<>(OK,rows);
    }

    @RequestMapping("all")
    public JsonResult<List<CourseVO>> findAllCourses(){
        List<CourseVO> data = courseService.findAllCourses();
        return new JsonResult<List<CourseVO>>(OK,data);
    }

    @RequestMapping("delete")
    public JsonResult<Void> deleteCourse(String cno){
        courseService.deleteCourse(cno);
        return new JsonResult<>(OK);
    }

    @RequestMapping("update")
    public JsonResult<Integer> updateCourse(Course course,HttpSession session){
        String mno = getMnoFromSession(session);
        Integer rows = courseService.updateCourse(course,mno);
        return new JsonResult<Integer>(OK,rows);
    }

    @RequestMapping("select_condition")
    public JsonResult<List> selectByCondition(String condition,@Param("key1")String key1,@Param("value1")String value1,
                                              @Param("key2")String key2,@Param("value2")String value2){
        List<CourseVO> data = courseService.selectByCondition(condition,key1,value1,key2,value2);
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("findVO")
    public JsonResult<CourseVO> findVOByCno(String cno){
        CourseVO data = courseService.findVOByCno(cno);
        return new JsonResult<>(OK,data);
    }

}
