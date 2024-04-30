package com.cy.school1.service;

import com.cy.school1.entity.Manager;
import com.cy.school1.entity.Student;
import com.cy.school1.entity.Teacher;

/* 用户模块业务层接口 */
public interface IManagerService {

    /*
    * 管理员登录功能
    * mno 管理员号
    * password 密码
    * @return 当前匹配的用户数据，如果没有返回null值
    *
    * */
    //登录，返回一个对象
    Manager mlogin(String mno, String password);


}
