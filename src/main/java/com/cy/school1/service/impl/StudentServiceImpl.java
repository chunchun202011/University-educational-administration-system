package com.cy.school1.service.impl;

import com.cy.school1.entity.Course;
import com.cy.school1.entity.Student;
import com.cy.school1.mapper.UserMapper;
import com.cy.school1.service.IStudentService;
import com.cy.school1.service.ex.*;
import com.cy.school1.vo.StudentSelectVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/*学生模块业务层的实现类*/
@Service  // @Service注解：将当前类的对象交给Spring来管理，可以自动创建对象及对象类的维护
public class StudentServiceImpl implements IStudentService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public void reg(Student student) {
        //通过student参数来获取传递过来的sno
        String sno = student.getSno();

        // 调用findBySno(sno)判断是否被注册过
        Student result = userMapper.findBySno(sno);
        //判断结果集是否不为null,则抛出学号被占用的异常
        if(result != null){
            //抛出异常
            throw new SnoDuplicatedException("学号被占用！");

        }
        // 补全数据：is_delete设置为0
        student.setIsDelete(0);
        // 补全数据：4个日志字段信息
        student.setCreatedUser(student.getSno());
        student.setModifiedUser(student.getSno());
        Date date = new Date();
        student.setCreatedTime(date);
        student.setModifiedTime(date);
        //执行注册业务功能的实现:rows==1
        Integer rows = userMapper.insert(student);
        if(rows != 1){
            throw new InsertException("在用户注册过程中产生了未知的异常");
        }
    }

    @Override
    public Student slogin(String sno, String password) {
        //根据用户名称查询用户数据是否存在，如果不存在就抛出异常
        Student result = userMapper.findBySno(sno);
        if (result==null){
            throw new UserNotFoundException("学生数据不存在！");
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
        if(result.getIsDelete()==1){
            throw new UserNotFoundException("用户数据不存在");
        }

        //调用mapper层的findBySno来查询用户的数据
        Student student = new Student();
        student.setSno(result.getSno());
        student.setSname(result.getSname());
        // 返回有用户的头像
        student.setAvatar(result.getAvatar());

        //将当前的用户数据返回，返回的数据是为了辅助其他页面展示使用(sno,sname,avatar)
        return student;
    }

    @Override
    public void changePassword(String sno, String sname,
                               String oldPassword, String newPassword) {
        Student result = userMapper.findBySno(sno);
        if(result == null || result.getIsDelete()==1){
            throw new UserNotFoundException("用户数据不存在");
        }
        //原始密码和数据库密码进行比较
        if (!result.getPassword().equals(oldPassword)){
            throw new PasswordNotMatchException("密码错误！");
        }
        //将新的密码设置到数据库中
        Integer rows = userMapper.updatePasswordBySno(
                            sno,newPassword,
                            sname,new Date());
        if(rows != 1){
            throw new UpdateException("更新数据产生异常！");
        }
    }

    @Override
    public Student getBySno(String sno) {
        Student result = userMapper.findBySno(sno);
        if (result == null || result.getIsDelete() ==1){
            throw new UserNotFoundException("用户没有被找到！");
        }
        Student student = new Student();
        student.setSname(result.getSname());
        student.setPassword(result.getPassword());
        student.setPhone(result.getPhone());
        student.setEmail(result.getEmail());
        student.setShome(result.getShome());
        student.setGender(result.getGender());
        student.setStatus(result.getStatus());
        return student;
    }

    @Override
    public void changeInfo(String sno, String sname, Student student) {
        Student result = userMapper.findBySno(sno);
        if (result == null || result.getIsDelete() ==1){
            throw new UserNotFoundException("用户没有被找到！");
        }
        student.setSno(sno);
        student.setModifiedUser(sname);
        student.setModifiedTime(new Date());

        Integer rows = userMapper.updateInfoBySno(student);
        if (rows != 1){
            throw new UpdateException("更新数据时产生未知异常！");
        }
    }

    @Override
    public void changeAvatar(String sno, String avatar, String sname) {
        //查询当前的用户数据是否存在
        Student result = userMapper.findBySno(sno);
        if (result == null || result.getIsDelete().equals(1)){
            throw new UserNotFoundException("用户数据不存在");
        }
        Integer rows = userMapper.updateAvatarBySno(sno,avatar,
                sname,new Date());
        if (rows != 1){
            throw new UpdateException("更新用户头像时产生未知异常");
        }


    }

    @Override
    public List<Student> selectByCondition(String condition,
            @Param("key1")String key1, @Param("value1")String value1,
            @Param("key2")String key2, @Param("value2")String value2) {
        List<Student> list =null;
        switch (condition){
            case "and":
                list = userMapper.selectByConditionAnd(key1,value1,key2,value2);
                break;
            case "or":
                list = userMapper.selectByConditionOr(key1,value1,key2,value2);
                break;
            case "not":
                list = userMapper.selectByConditionNot(key1,value1,key2,value2);
                break;
        }
        return list;
    }

//    @Override
//    public List<Student> selectByConditionOr(String sno, String sname, Integer gender) {
//        Student student = new Student();
//        student.setSno(sno);
//        student.setSname(sname);
//        student.setGender(gender);
//        List<Student> list = userMapper.selectByConditionOr(student);
//        return list;
//    }
//
//    @Override
//    public List<Student> selectByConditionNot(String sno, String sname, Integer gender) {
//        Student student = new Student();
//        student.setSno(sno);
//        student.setSname(sname);
//        student.setGender(gender);
//        List<Student> list = userMapper.selectByConditionNot(student);
//        return list;
//    }

    @Override
    public List<Student> selectAllStudent() {
        List<Student> list = userMapper.selectAllStudent();
        return list;
    }

    @Override
    public List<StudentSelectVO> selectMyStudent(String tno) {
        List<StudentSelectVO> list = userMapper.selectMyStudent(tno);
        return list;
    }

    @Override
    public void deleteBySno(String sno) {
        userMapper.deleteBySno(sno);
    }

    @Override
    public void insertStudent(String mno,Student student) {
            student.setIsDelete(0);
            student.setCreatedTime(new Date());
            student.setCreatedUser(mno);
            student.setModifiedTime(new Date());
            student.setModifiedUser(mno);
            Integer rows = userMapper.insert(student);
            if (rows <= 0 ){
                throw new InsertException("插入学生信息异常！");
            }
    }

    @Override
    public List<Student> selectNotDeleteStudent() {
        List<Student> students = userMapper.findNotDeleteStudent();
        return students;
    }

    @Override
    public void deleteFalseBySno(String sno,String mno) {
        Student student = userMapper.findBySno(sno);
        student.setModifiedUser(mno);
        student.setModifiedTime(new Date());
        student.setIsDelete(1);
        userMapper.updateStudent(student);
    }

    @Override
    public Integer updateStudent(Student student, String mno) {
        student.setModifiedUser(mno);
        student.setModifiedTime(new Date());
        Integer rows = userMapper.updateStudent(student);
        if (rows <= 0 ){
            throw new UpdateException("删除学生异常！");
        }
        return rows;
    }

    @Override
    public List<Student> notScoreStudent(String cno) {
        List<Student> list = userMapper.notScoreStudent(cno);
        return list;
    }
}
