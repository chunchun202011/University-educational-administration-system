package com.cy.school1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.MultipartConfigElement;


@Configuration // 表示配置类
@SpringBootApplication(scanBasePackages = "com.cy.school1")
@RestController
@MapperScan("com.cy.school1.mapper")
public class School1Application {

    public static void main(String[] args) {
        SpringApplication.run(School1Application.class, args);
    }

    @Bean
    public MultipartConfigElement getMultipartConfigElement(){
        //创建一个配置的工厂类对象
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //设置需要创建的对象相关信息
        factory.setMaxFileSize(DataSize.of(10,
                DataUnit.MEGABYTES));
        factory.setMaxRequestSize(DataSize.of(15,
                DataUnit.MEGABYTES));

        //通过工厂类来创建MultipartConfigElement对象
        return factory.createMultipartConfig();
    }
}
