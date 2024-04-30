package com.cy.school1.controller;

import com.cy.school1.controller.ex.ex.*;
import com.cy.school1.service.ex.*;
import com.cy.school1.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


/* 控制层的基类 */
public class BaseController {
    /* 操作成功的状态码 */
    public static final int OK = 200;

    // 请求处理方法，这个方法的返回值就是需要传递给全端的数据
    // 自动将异常对象传递给此方法的参数列表上
    // 当项目中产生了异常，被统一拦截到此方法中，这个方法充当请求处理方法，方法的返回值直接给前端
    @ExceptionHandler({ServiceException.class,FileUploadException.class}) //用于统一处理抛出的异常
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof SnoDuplicatedException){
            result.setState(4000);
            result.setMessage("学号已存在！");
        }else if(e instanceof UserNotFoundException) {
            result.setState(4001);
            result.setMessage("数据不存在的异常！");
        }else if(e instanceof PasswordNotMatchException) {
            result.setState(4002);
            result.setMessage("密码错误！");
        }else if(e instanceof ScoreCountLimitException) {
            result.setState(4003);
            result.setMessage("成绩数据超出上限！");
        }else if(e instanceof CourseNotFoundException) {
            result.setState(4004);
            result.setMessage("课程数据不存在！");
        }  else if(e instanceof SCNotFoundException){
            result.setState(4005);
            result.setMessage("选课数据不存在！");
        } else if(e instanceof InsertException){
            result.setState(5000);
            result.setMessage("注册时产生未知的异常");
        }else if(e instanceof UpdateException){
            result.setState(5001);
            result.setMessage("更新数据时产生未知的异常");
        } else if(e instanceof AccessDeniedException){
            result.setState(5002);
            result.setMessage("用户非法访问！");
        }else if(e instanceof FileEmptyException){
            result.setState(6000);
            result.setMessage("文件为空的异常");
        }else if(e instanceof FileSizeException){
            result.setState(6001);
            result.setMessage("文件过大！");
        }else if(e instanceof FileTypeException){
            result.setState(6002);
            result.setMessage("文件格式错误！");
        }else if(e instanceof FileStateException){
            result.setState(6003);
            result.setMessage("文件状态异常！");
        }else if(e instanceof FileUploadIOException){
            result.setState(6004);
            result.setMessage("文件更新产生未知的异常");
        }
            return result;
    }

    /*
    *获取session对象中的sno
    * session  session对象
    * return 当前登录的用户sno的值
    *
    * */
    protected final String getSnoFromSession(HttpSession session){
        //主键sno作为key来使用，返回值是一个对象，因为session中保存的是任何数据类型
        //cookie中保存的是String类型
       return String.valueOf(session.getAttribute("sno")
               .toString());
    }

    /*
    * 获取当前登录用户的sname
    * session session对象
    * return 当前登录的用户名
    *
    * 在实现类中重写父类的toString(),不是句柄信息的输出
    *
    * */
    protected final String getSnameFromSession(HttpSession session){
        return session.getAttribute("sname").toString();
    }


    protected final String getTnoFromSession(HttpSession session){
        //主键tno作为key来使用，返回值是一个对象，因为session中保存的是任何数据类型
        //cookie中保存的是String类型
        return String.valueOf(session.getAttribute("tno")
                .toString());
    }

    protected final String getTnameFromSession(HttpSession session){
        return session.getAttribute("tname").toString();
    }


    protected final String getMnoFromSession(HttpSession session){
        //主键tno作为key来使用，返回值是一个对象，因为session中保存的是任何数据类型
        //cookie中保存的是String类型
        return String.valueOf(session.getAttribute("mno")
                .toString());
    }

    protected final String getMnameFromSession(HttpSession session){
        return session.getAttribute("mname").toString();
    }

}
