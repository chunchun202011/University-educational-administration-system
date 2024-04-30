package com.cy.school1.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 定义一个拦截器 */
public class LoginInterceptor implements HandlerInterceptor {

    /*
    * 检测全局session对象中是否有sno数据，如果有则放行，没有就重定向到登录
    * request 请求对象
    * response 响应对象
    * handler 处理器(url+Controller:映射)
    * return 如果返回值为true表示放行当前请求，false表示拦截当前请求
    * Exception
    *
    *
    * */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        // HttpServletRequest对象来获取session对象
//        Object obj = request.getSession().getAttribute("sno");
        Object obj = request.getSession();
//        if(obj == null){
//            //说明用户没有登录过系统，则重定向到login.html页面
//            response.sendRedirect("/total.html");
//            //结束后续的调用
//            return false;
//        }

        if(obj == null){
            //说明用户没有登录过系统，则重定向到login.html页面
            response.sendRedirect("/total.html");
            //结束后续的调用
            return false;
        }

//        Object obj1 = request.getSession().getAttribute("tno");
//        if(obj1 == null){
//            //说明用户没有登录过系统，则重定向到login.html页面
//            response.sendRedirect("/total.html");
//            //结束后续的调用
//            return false;
//        }
//
//        Object obj2 = request.getSession().getAttribute("mno");
//        if(obj2 == null){
//            //说明用户没有登录过系统，则重定向到login.html页面
//            response.sendRedirect("/total.html");
//            //结束后续的调用
//            return false;
//        }



        //请求放行
        return true;
    }
}
