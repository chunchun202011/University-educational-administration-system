package com.cy.school1.service;

import com.cy.school1.entity.Manager;
import com.cy.school1.entity.Student;
import com.cy.school1.entity.Teacher;
import com.cy.school1.service.ex.ServiceException;
import com.cy.school1.vo.StudentSelectVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

// @SpringBootTest:表示标注当前的类是一个测试类，不会随同项目一块打包发送
@SpringBootTest
// @RunWith:表示启动这个单元测试类(单元测试类是不能运行的)，需要传递一个参数，必须是SpringRunner的实例类型
@RunWith(SpringRunner.class)
public class UserServiceTests {

    //idea有检测的功能，接口是不能够直接创建Bean的(动态代理技术来解决)
    @Autowired
    private IStudentService studentService;
    @Autowired
    private ITeacherService teacherService;
    @Autowired
    private IManagerService managerService;
    /*
    * 单元测试方法：可以独立运行，不用启动整个项目，做单元测试，提升效率
    * 1.必须被Test注解修饰
    * 2.返回值类型必须是void
    * 3.方法的参数列表不能指定任何类型
    * 4.方法的访问修饰符必须是public
    * */

    @Test
    public void reg(){
        try {
            Student student = new Student();
            student.setSno("3221702999");
            student.setSname("刘丹");
            student.setPassword("3221702999");
            studentService.reg(student);
            System.out.println("OK");
        } catch (ServiceException e) {
            //先获取类的对象，再获取异常类的名称
            System.out.println(e.getClass().getSimpleName());
            // 获取异常的具体描述信息
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void slogin(){
        Student student = studentService.slogin("3221702938","3221702938");
        System.out.println(student);
    }

    @Test
    public void changePassword(){
        studentService.changePassword("3221702940","管理员",
                                "3221702940","3221702940" );
    }

    @Test
    public void getBySno(){
        System.out.println(studentService.getBySno("3221702938"));
    }

    @Test
    public void changeInfo(){
        Student student = new Student();
        student.setPhone("17231278138");
        student.setEmail("linmmu@126.com");
        student.setGender(1);
        studentService.changeInfo("3221702938","管理员",student);
    }

    @Test
    public void changeAvatar(){
        studentService.changeAvatar("3221702938",
                "/upload/test.jpg",
                "小满");
    }

    /*教师的测试*/
    @Test
    public void regT(){
        try {
            Teacher teacher= new Teacher();
            teacher.setTno("20127185");
            teacher.setTname("李东");
            teacher.setPassword("20127185");
            teacherService.regT(teacher);
            System.out.println("OK");
        } catch (ServiceException e) {
            //先获取类的对象，再获取异常类的名称
            System.out.println(e.getClass().getSimpleName());
            // 获取异常的具体描述信息
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void tlogin(){
        Teacher teacher =
                teacherService.tlogin("12312941","12312941");
        System.out.println(teacher);
    }

    @Test
    public void mlogin(){
        Manager manager = managerService.mlogin("50200","50200");
        System.out.println(manager);

    }

//    @Test
//    public void selectByConditionAnd(){
//        List<Student> list = studentService.selectByConditionAnd("3221702938","林木",1);
//        System.out.println(list);
//    }

    @Test
    public void selectByCondition(){
        List<Student> list = studentService.selectByCondition("and","sno","32","sname","林木");
        List<Student> list1 = studentService.selectByCondition("or","sno","32","sname","林木");
        List<Student> list2 = studentService.selectByCondition("not","sno","32","sname","林木");
        System.out.println("and查询结果：");
        System.out.println(list);
        System.out.println("or查询结果：");
        System.out.println(list1);
        System.out.println("not查询结果：");
        System.out.println(list2);
    }

//    @Test
//    public void selectByConditionOr(){
//        List<Student> list = studentService.selectByConditionOr("3221702938","林木",1);
//        System.out.println(list);
//    }
//
//    @Test
//    public void selectByConditionNot(){
//        List<Student> list = studentService.selectByConditionNot("3221702938","林木",1);
//        System.out.println(list);
//    }

    @Test
    public void selectMyStudent(){
        List<StudentSelectVO> list = studentService.selectMyStudent("20127186");
        System.out.println(list);
    }

    @Test
    public void findAllTeachers(){
        List<Teacher> list = teacherService.findAllTeachers();
        System.out.println(list);
    }

    @Test
    public void deleteBySno() {
        studentService.deleteBySno("1111111111");
    }

    @Test
    public void insertStudent(){
        try {
            Student student = new Student();
            String mno = "50200";
            student.setSno("111");
            student.setSname("陆飞");
            student.setPassword("111");
            studentService.insertStudent(mno,student);
            System.out.println("OK");
        } catch (ServiceException e) {
            //先获取类的对象，再获取异常类的名称
            System.out.println(e.getClass().getSimpleName());
            // 获取异常的具体描述信息
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void deleteFalseBySno(){
        studentService.deleteFalseBySno("3221702999","50200");
    }

    @Test
    public void notScoreStudent(){
        List<Student> list = studentService.notScoreStudent("10212");
        System.out.println(list);
    }
}
