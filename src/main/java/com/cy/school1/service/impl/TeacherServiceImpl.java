package com.cy.school1.service.impl;

import com.cy.school1.entity.Student;
import com.cy.school1.entity.Teacher;
import com.cy.school1.mapper.UserMapper;
import com.cy.school1.service.ITeacherService;
import com.cy.school1.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/*学生模块业务层的实现类*/
@Service  // @Service注解：将当前类的对象交给Spring来管理，可以自动创建对象及对象类的维护
public class TeacherServiceImpl implements ITeacherService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public void regT(Teacher teacher) {
        //通过teacher参数来获取传递过来的tno
        String tno = teacher.getTno();
        // 调用findByTno(tno)判断是否被注册过
        Teacher result = userMapper.findByTno(tno);
        //判断结果集是否不为null,则抛出教工号被占用的异常
        if(result != null){
            //抛出异常
            throw new SnoDuplicatedException("教工号被占用！");
        }
        // 补全数据：is_delete设置为0
        teacher.setIsDelete(0);
        // 补全数据：4个日志字段信息
        teacher.setCreatedUser(teacher.getTno());
        teacher.setModifiedUser(teacher.getTno());
        Date date = new Date();
        teacher.setCreatedTime(date);
        teacher.setModifiedTime(date);

        //执行注册业务功能的实现:rows==1
        Integer rows = userMapper.insertT(teacher);
        if(rows != 1){
            throw new InsertException("在用户注册过程中产生了未知的异常");
        }
    }

    @Override
    public Teacher tlogin(String tno, String password) {
        //根据用户名称查询用户数据是否存在，如果不存在就抛出异常
        Teacher result = userMapper.findByTno(tno);
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
        Teacher teacher = new Teacher();
        teacher.setTno(result.getTno());
        teacher.setTname(result.getTname());
        // 返回有用户的头像
        teacher.setAvatar(result.getAvatar());

        //将当前的用户数据返回，返回的数据是为了辅助其他页面展示使用(sno,sname,avatar)
        return teacher;
    }

    @Override
    public void changePassword(String tno, String tname, String oldPassword, String newPassword) {

    }

    @Override
    public Student getBySno(String sno) {
        return null;
    }

    @Override
    public void changeInfo(String tno, String tname, Teacher teacher) {

    }

    @Override
    public void changeAvatar(String tno, String avatar, String tname) {

    }

    @Override
    public List<Teacher> findAllTeachers() {
        List<Teacher> list = userMapper.findAllTeachers();
        return list;
    }

}
