package com.cy.school1.service;

import com.cy.school1.entity.Student;
import com.cy.school1.vo.StudentSelectVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/* 用户模块业务层接口 */
public interface IStudentService {
    /*
    * 用户注册方法
    * student 用户的数据对象
    *
    * */
    void reg(Student student);

    /*
    * 学生登录更能
    * sno 学号
    * password 密码
    * @return 当前匹配的用户数据，如果没有返回null值
    *
    * */
    //登录，返回一个对象
    Student slogin(String sno,String password);

    void changePassword(String sno,
                        String sname,
                        String oldPassword,
                        String newPassword);

    /*
    * 根据用户sno查询用户的数据
    * sno 用户sno
    * return 用户数据
    *
    * */
    Student getBySno(String sno);

    /*
    * 更新用户的数据操作
    * sno 学号
    * sname 学生名
    * student 对象数据
    *
    * */
    void changeInfo(String sno,String sname,Student student);

    /**
     * 修改用户的头像
     * @param sno 学号
     * @param avatar 用户头像路径
     * @param sname 学生名
     */
    void changeAvatar(String sno,
                      String avatar,
                      String sname);

    // and or not三种条件查询
//    List<Student> selectByConditionAnd(String sno, String sname, Integer gender);
    List<Student> selectByCondition(@Param("condition") String condition,
            @Param("key1") String key1, @Param("value1") String value1,
              @Param("key2") String key2, @Param("value2") String value2);
//    List<Student> selectByConditionOr(String sno, String sname, Integer gender);
//    List<Student> selectByConditionNot(String sno, String sname, Integer gender);

    //查询所有学生信息
    List<Student> selectAllStudent();

    // 查询自己的学生
    List<StudentSelectVO> selectMyStudent(String tno);

    void deleteBySno(String sno);

    void insertStudent(String mno,Student student);

    //查询所有学生信息
    List<Student> selectNotDeleteStudent();

    //删除学生(isDelete=1)
    void deleteFalseBySno(String sno,String mno);

    //更新学生
    Integer updateStudent(Student student,String mno);

    List<Student> notScoreStudent(String cno);
}
