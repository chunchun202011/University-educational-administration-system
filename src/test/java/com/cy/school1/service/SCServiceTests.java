package com.cy.school1.service;

import com.cy.school1.entity.Course;
import com.cy.school1.entity.SC;
import com.cy.school1.entity.Student;
import com.cy.school1.mapper.CourseMapper;
import com.cy.school1.mapper.SCMapper;
import com.cy.school1.service.ex.InsertException;
import com.cy.school1.service.ex.UpdateException;
import com.cy.school1.vo.SCVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@MapperScan("com.cy.school1.mapper")
@SpringBootTest
@RunWith(SpringRunner.class)
public class SCServiceTests {

    @Autowired
    private ISCService scService;
    @Autowired
    private ICourseService courseService;

    @Autowired
    private IStudentService studentService;

    @Test
    public void addToSCCart(){
        //已存在的课程数量更新
        scService.addToSCCart("3221702950","11005",1,"元满");
//        Course course = courseService.findByCno("11005");
//        System.out.println(course.getCredit());
//        System.out.println(courseService.findByCno("11005"));

    }

    @Autowired
    private SCMapper scMapper;
    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void add(){
        //查询当前要添加的数据在表中是否已存在
        String sno = "1243123111";
        String cno = "11005";
        Integer amount = 1;
        Student student = studentService.getBySno("1243123111");
        String sname = student.getSname();
        SC result = scMapper.findBySnoCno(sno,cno);
        Date date = new Date();
        if (result == null){    //表示这个选课从来没有被添加到课表中，进行新增操作
            //创建一个sc对象
            SC sc = new SC();
            //补全数据
            sc.setSno(sno);
            sc.setCno(cno);
            sc.setTerm(amount);
            // 补全学分：来自课程中的数据
            Course course = courseMapper.findByCno(cno);
            System.out.println(course);
            sc.setTotal(course.getCredit());
            //获取单价的数据，乘法运算在选修列表中做
            //补全4日志
            sc.setCreatedUser(student.getSname());
            sc.setCreatedTime(date);
            sc.setModifiedUser(student.getSname());
            sc.setModifiedTime(date);
            //执行输入的插入操作
            Integer rows = scMapper.insert(sc);
            if (rows!=1){
                throw new InsertException("插入数据时产生未知的异常！");
            }
        }else{  // 表示当前的课程在选课表中已存在，则更新数据的term值
            // 进行原有数据和现有传递数据进行相加操作（前端、后端业务层）
            Integer term = result.getTerm() + amount;
            Integer rows = scMapper.updateTermBySnoCno(result.getSno(), result.getCno(),
                    term,sname, date);
            if(rows!=1){
                throw new UpdateException("更新时异常！");
            }
        }
    }

    @Test
    public void reduceTerm(){
        Integer rows = scService.reduceTerm("11005","1243123111","王飞");
        System.out.println(rows);
    }

    @Test
    public void getVOByCno(){
        String[] cnos = {"11001","11005"};
        List<SCVO> data = scService.getVOByCno("3221702938",cnos);
        System.out.println(data);
    }

    @Test
    public void deleteSC(){
        scService.deleteSC("3221702938","11001");
    }

    @Test
    public void deleteManySCs(){
        String[] cnos = {"11001","11002"};
        Integer rows = scService.deleteManySCs("3221702938",cnos);
        System.out.println(rows);
    }

    @Test
    public void findStudentsSCs(){
        List<SCVO> scs = scService.findAllStudentsSCs();
        System.out.println(scs);
    }

    @Test
    public void updateSC(){
        int rows = scService.updateSC("11213","11111","124","haha");
        System.out.println(rows);
    }

    @Test
    public void addSC(){
        Integer rows = scService.saddSC("1231","3121");
        System.out.println(rows);
    }

    @Test
    public void findMyStuSC(){
        List<SCVO> scs = scService.findMyStuSC("12312941");
        System.out.println(scs);
    }

}
