package com.cy.school1.service.impl;

import com.cy.school1.entity.Manager;
import com.cy.school1.entity.Student;
import com.cy.school1.entity.Teacher;
import com.cy.school1.mapper.UserMapper;
import com.cy.school1.service.IManagerService;
import com.cy.school1.service.ITeacherService;
import com.cy.school1.service.ex.InsertException;
import com.cy.school1.service.ex.PasswordNotMatchException;
import com.cy.school1.service.ex.SnoDuplicatedException;
import com.cy.school1.service.ex.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/*学生模块业务层的实现类*/
@Service  // @Service注解：将当前类的对象交给Spring来管理，可以自动创建对象及对象类的维护
public class ManagerServiceImpl implements IManagerService {

    @Autowired(required = false)
    private UserMapper userMapper;


    @Override
    public Manager mlogin(String mno, String password) {
        //根据用户名称查询用户数据是否存在，如果不存在就抛出异常
        Manager result = userMapper.findByMno(mno);
        if (result==null){
            throw new UserNotFoundException("用户数据不存在！");
        }
        //检测用户的密码是否匹配
        //1.获取数据库中的密码
        String oldpassword = result.getPassword();
        //2.和用户传递的密码进行比较
      //  String newpassword = result.getPassword();
        //3.将密码进行比较
        if(!password.equals(oldpassword)){
            throw new PasswordNotMatchException("用户密码错误");
        }

        //判断is_delete字段的值是否为1，表示标记为删除
//        if(result.getIsDelete()==1){
//            throw new UserNotFoundException("用户数据不存在");
//        }

        //调用mapper层的findByTno来查询用户的数据
        Manager manager = new Manager();
        manager.setMno(result.getMno());
        manager.setMname(result.getMname());

        //将当前的用户数据返回，返回的数据是为了辅助其他页面展示使用(mno,mname)
        return manager;
    }

}
