package com.cy.school1.service;

import com.cy.school1.entity.Student;
import com.cy.school1.entity.Teacher;

import java.util.List;

/* 用户模块业务层接口 */
public interface ITeacherService {
    /*
    * 用户注册方法
    * student 用户的数据对象
    *
    * */
    void regT(Teacher teacher);

    /*
    * 学生登录更能
    * sno 学号
    * password 密码
    * @return 当前匹配的用户数据，如果没有返回null值
    *
    * */
    //登录，返回一个对象
    Teacher tlogin(String tno,String password);

    void changePassword(String tno,
                        String tname,
                        String oldPassword,
                        String newPassword);

    /*
    * 根据用户tno查询用户的数据
    * tno 用户tno
    * return 用户数据
    *
    * */
    Student getBySno(String sno);

    /*
    * 更新用户的数据操作
    * tno 教工号
    * tname 教师名
    * teacher 对象数据
    *
    * */
    void changeInfo(String tno,String tname,Teacher teacher);

    /**
     * 修改用户的头像
     * @param tno 教工号
     * @param avatar 用户头像路径
     * @param tname 教师名
     */
    void changeAvatar(String tno,
                      String avatar,
                      String tname);

    List<Teacher> findAllTeachers();

}
