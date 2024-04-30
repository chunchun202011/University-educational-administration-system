package com.cy.school1.controller;

import com.cy.school1.entity.Manager;
import com.cy.school1.entity.Teacher;
import com.cy.school1.service.IManagerService;
import com.cy.school1.service.ITeacherService;
import com.cy.school1.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

// @Controller
//@SpringBootApplication(scanBasePackages= "com.cy.school1.controller")
@RestController  //@Controller + @ResponseBody
//声明什么样的请求可以被拦截
@RequestMapping("managers")
public class ManagerController extends BaseController{
    @Autowired
    private IManagerService managerService;

    @RequestMapping("mlogin")   //注意是mlogin
    public JsonResult<Manager> mlogin(String mno,
                                      String password,
                                      HttpSession session){
        Manager data = managerService.mlogin(mno,password);
        //向session对象中完成数据的绑定
        session.setAttribute("mno",data.getMno());
        session.setAttribute("mname",data.getMname());

        //获取session中绑定的数据
        System.out.println(getMnoFromSession(session));
        System.out.println(getMnameFromSession(session));
        return new JsonResult<Manager>(OK,data);
    }
}
