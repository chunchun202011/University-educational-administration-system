package com.cy.school1.controller;

import com.cy.school1.controller.ex.ex.*;
import com.cy.school1.entity.Course;
import com.cy.school1.entity.Student;
import com.cy.school1.service.IStudentService;
import com.cy.school1.util.JsonResult;
import com.cy.school1.vo.StudentSelectVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// @Controller
//@SpringBootApplication(scanBasePackages= "com.cy.school1.controller")
@RestController  //@Controller + @ResponseBody
//声明什么样的请求可以被拦截
@RequestMapping("students")
public class StudentController extends BaseController{
    @Autowired
    private IStudentService studentService;

    /*
    * 约定大于配置开发思想来完成，省略大量配置注解编写
    *1.接收数据方式：请求处理方法的参数列表设置为pojo类型来接收前端数据，
    * SpringBoot会将前端的url地址中的参数名和pojo类的属性名进行比较，如果
    * 这两个名称相同，则将值注入到pojo类中对应的属性上
    * */
    @RequestMapping("reg")  //接收什么样的请求
    // @ResponseBody  //表示此方法的响应结果以json格式进行数据的响应给到前端
    public JsonResult<Void> reg(Student student) {
        //创建响应结果对象
        studentService.reg(student);
        return new JsonResult<>(OK);
    }
    /*
    @RequestMapping("reg")  //接收什么样的请求
    // @ResponseBody  //表示此方法的响应结果以json格式进行数据的响应给到前端
    public JsonResult<Void> reg(Student student){
        //创建响应结果对象
        JsonResult<Void> result = new JsonResult<>();
        try{
            studentService.reg(student);
            result.setState(200);
            result.setMessage("学生注册成功");
        }catch (SnoDuplicatedException e){
            result.setState(4000);
            result.setMessage("学号已存在");
        }catch (InsertException e){
            result.setState(5000);
            result.setMessage("注册时产生未知的异常");
        }
        return result;
    }
     */


    /*
     *2.接收数据方式：请求处理方法的参数列表设置为非pojo类型，
     * SpringBoot直接将请求的参数名和方法的参数名进行比较，如果
     * 名称相同则自动完成值的注入
     * */
    @RequestMapping("slogin")   //注意是slogin
    public JsonResult<Student> slogin(String sno,
                                      String password,
                                      HttpSession session){
        Student data =  studentService.slogin(sno,password);
        //向session对象中完成数据的绑定
        session.setAttribute("sno",data.getSno());
        session.setAttribute("sname",data.getSname());

        //获取session中绑定的数据
        System.out.println(getSnoFromSession(session));
        System.out.println(getSnameFromSession(session));
        return new JsonResult<Student>(OK,data);
    }

    @RequestMapping("change_password")
    public JsonResult<Void> changePassword(String oldPassword,
                                           String newPassword,
                                           HttpSession session){
        String sno = getSnoFromSession(session);
        String sname = getSnameFromSession(session);
        studentService.changePassword(sno,sname,
                oldPassword,newPassword);
        return new JsonResult<>(OK);
    }

    /* 获取用户信息 */
    @RequestMapping("get_by_sno")
    public JsonResult<Student> getBySno(HttpSession session){
       Student data =
            studentService.getBySno(getSnoFromSession(session));
        return new  JsonResult<>(OK,data);
    }

    @RequestMapping("change_info")
    public JsonResult<Void> changeInfo(Student student,
                                       HttpSession session){
        //student对象有四部分的数据：sname,phone,email,gender
        // sno数据需要再次封装到student对象中
        String sno = getSnoFromSession(session);
        String sname = getSnameFromSession(session);
        studentService.changeInfo(sno,sname,student);
        return new JsonResult<>(OK);
    }

    /* 设置上传文件的最大值 */
    public static final int AVATAR_MAX_SIZE = 20 * 1024 * 1024;

    /* 设置上传文件的类型 */
    public static final List<String> AVATAR_TYPE = new ArrayList<>();

    static {
        AVATAR_TYPE.add("image/jpeg"); //包含jpg
        AVATAR_TYPE.add("image/jpg");
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/bmp");
        AVATAR_TYPE.add("image/gif");
    }

    /**
     * MultipartFile接口是SpringMVC提供一个接口，这个接口为我们包装了
     * 获取文件类型的数据(任何类型的file都可以接收),SpringBoot整合了SpringMVC，
     * 只需要在处理请求的方法列表上声明一个参数类型为Multipart的参数，然后SpringBoot
     * 自动将传递给服务的文件数据赋值给这个参数
     * @RequestParam 表示请求中的参数，将请求中的参数注入请求处理方法的某个参数上，
     * 如果名称不一致则可以使用@RequestParam注解进行标记和映射
     *
     * @param session
     * @param file
     * @return
     */
    @RequestMapping("change_avatar")
    public JsonResult<String> changeAvatar(
            HttpSession session,
            //MultipartFile file) {   //把整体数据包传递过来，与前端的file名字对应
          //若前端叫f,后端这里叫file:(名字不一致时)  @RequestParam("file") MultipartFile file
            MultipartFile file) {
        //判断文件是否为空
        if (file.isEmpty()) {
            throw new FileEmptyException("文件为空");
        }
        if (file.getSize() > AVATAR_MAX_SIZE) {
            throw new FileSizeException("文件超出限制");
        }
        //判断文件的类型是否是我们规定的和后缀类型
        String contentType = file.getContentType();
        //如果集合包含某个元素则返回值true
        if (!AVATAR_TYPE.contains(contentType)) {
            throw new FileTypeException("文件类型不支持");
        }
        //上传的文件.../upload/文件.png
        String parent =
                session.getServletContext()
                        .getRealPath("upload");
       // String parent = "D:/drc/school/upload"; //改成固定路径

        //File对象指向这个路径，File是否存在
        File dir = new File(parent);
        if (!dir.exists()) { //检测目录是否存在
            dir.mkdirs(); //创建当前的目录
        }
        //获取到这个文件名称，UUID工具来生成一个新的字符串作为新的文件名
        // 例如:avatar01.png
        String originalFilename = file.getOriginalFilename();
        System.out.println(originalFilename);
        //获取后缀
        int index = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(index);
        // AHSDI1-23QIE-WBSUW-GSYWEU-8297AS-HDUDG2.png
        String filename =
                UUID.randomUUID().toString().toUpperCase()
                        + suffix;
        File dest = new File(dir, filename); //根目录dir,文件名filename,是一个空文件
        //将参数file中数据写入空文件中
        try {
            file.transferTo(dest);  //将file文件中数据写入到dest文件中
        }catch (FileStateException e){
            throw new FileStateException("文件状态异常");
        }catch (IOException e) {
            throw new FileUploadIOException("文件读写异常");
        }

        String sno = getSnoFromSession(session);
        String sname = getSnameFromSession(session);
        //返回头像的路径/upload/test.png
        String avatar = "/upload/"  + filename;
        studentService.changeAvatar(sno,avatar,sname);
        // 返回用户头像的路径给前端页面，将来用于头像的展示使用
        return new JsonResult<>(OK,avatar);
    }

    @RequestMapping("select_condition")
    public JsonResult<List> selectByCondition(String condition,@Param("key1")String key1,@Param("value1")String value1,
                                                 @Param("key2")String key2,@Param("value2")String value2){
        List<Student> data = studentService.selectByCondition(condition,key1,value1,key2,value2);
//        studentService.changeInfo(sno,sname,student);
        return new JsonResult<>(OK,data);
    }

//    @RequestMapping("select_or")
//    public JsonResult<List> selectByConditionOr(String sno,String sname,Integer gender){
//        List<Student> data = studentService.selectByConditionOr(sno,sname,gender);
////        studentService.changeInfo(sno,sname,student);
//        return new JsonResult<>(OK,data);
//    }
//
//    @RequestMapping("select_not")
//    public JsonResult<List> selectByConditionNot(String sno,String sname,Integer gender){
//        List<Student> data = studentService.selectByConditionNot(sno,sname,gender);
////        studentService.changeInfo(sno,sname,student);
//        return new JsonResult<>(OK,data);
//    }

    @RequestMapping("list")
    public JsonResult<List> selectAllStudent(){
        List<Student> data = studentService.selectAllStudent();
        return new JsonResult<>(OK,data);
    }
    @RequestMapping("my_student")
    public JsonResult<List<StudentSelectVO>> selectMyStudent(HttpSession session){
        String tno = getTnoFromSession(session);
        List<StudentSelectVO> data = studentService.selectMyStudent(tno);
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("delete")
    public JsonResult<Void> deleteStudent(String sno){
        studentService.deleteBySno(sno);
        return new JsonResult<>(OK);
    }

    @RequestMapping("insert")
    public JsonResult<Void> insertStudent(HttpSession session,Student student){
        String mno = getMnoFromSession(session);
        studentService.insertStudent(mno,student);
        return new JsonResult<>(OK);
    }

    @RequestMapping("allNotDelete")
    public JsonResult<List> selectNotDeleteStudent(){
        List<Student> data = studentService.selectNotDeleteStudent();
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("fdelete")
    public JsonResult<Void> deleteFalseStudent(String sno,HttpSession session){
        String mno = getMnoFromSession(session);
        studentService.deleteFalseBySno(sno,mno);
        return new JsonResult<>(OK);
    }

    @RequestMapping("update")
    public JsonResult<Integer> updateStudent(Student student,HttpSession session){
        String mno = getMnoFromSession(session);
        Integer rows = studentService.updateStudent(student,mno);
        return new JsonResult<Integer>(OK,rows);
    }

    @RequestMapping("{sno}/details")
    public JsonResult<Student> findBySno(@PathVariable("sno") String sno){
        //调用业务对象执行获取数据
        Student data = studentService.getBySno(sno);
        //返回成功和数据
        return new JsonResult<Student>(OK,data);
    }

    @RequestMapping("not_score")
    public JsonResult<List<Student>> notScoreStudent(String cno){
        //调用业务对象执行获取数据
        List<Student> data = studentService.notScoreStudent(cno);
        //返回成功和数据
        return new JsonResult<List<Student>>(OK,data);
    }

}
