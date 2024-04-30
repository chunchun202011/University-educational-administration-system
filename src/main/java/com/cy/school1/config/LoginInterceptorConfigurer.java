package com.cy.school1.config;

import com.cy.school1.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/* 处理器拦截器的注册 */
@Configuration  // 加载当前的拦截器并进行注册
public class LoginInterceptorConfigurer implements WebMvcConfigurer {

    //将自定义拦截器进行注册
    /* 配置拦截器 */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //创建自定义的拦截器对象
        HandlerInterceptor interceptor = new LoginInterceptor();
        // 配置白名单：存放在一个List集合
        List<String> patterns = new ArrayList<>();
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        patterns.add("/total.html");
        patterns.add("/web/register.html");
        patterns.add("/web/tregister.html");
        patterns.add("/web/login.html");
        patterns.add("/web/tlogin.html");
        patterns.add("/web/tindex.html");
        patterns.add("/web/mlogin.html");
        patterns.add("/web/index.html");
        patterns.add("/web/product.html");
        patterns.add("/web/scores.html");
        patterns.add("/web/addScore.html");
        patterns.add("/web/selectStudent.html");
        patterns.add("/web/selectOrders.html");
        patterns.add("/web/myTCourse.html");
        patterns.add("/web/myStudent.html");
        patterns.add("/web/updateScore.html");
        patterns.add("/students/reg");
        patterns.add("/students/slogin");
        patterns.add("/students/my_student");
        patterns.add("/students/select_condition");
        patterns.add("/students/select_and");
        patterns.add("/students/select_or");
        patterns.add("/students/select_not");
        patterns.add("/students/list");
        patterns.add("/orders/list");
        patterns.add("/orders/condition");
        patterns.add("/teachers/regt");
        patterns.add("/teachers/tlogin");
        patterns.add("/managers/mlogin");
        patterns.add("/sdepts/**");
        patterns.add("/scores/**");
        patterns.add("/courses/**");
        patterns.add("/courses/teacher");
        patterns.add("/courses/all");
        patterns.add("/scores/{sno}/{cno}/delete");
        patterns.add("/scores/add_new_score");
        patterns.add("/scores/update");
        patterns.add("/file/download_1");
        patterns.add("/score/update");
        patterns.add("/score/delete");
        patterns.add("/news/details");
        //完成拦截器的注册
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(patterns); //表示要拦截的url是什么

    }
}
