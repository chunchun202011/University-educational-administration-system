package com.cy.school1.service;

import com.cy.school1.entity.SdeptTable;
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
public class SdeptServiceTests {

    //idea有检测的功能，接口是不能够直接创建Bean的(动态代理技术来解决)
    @Autowired
    private ISdeptService sdeptService;

    @Test
    public void getByParent(){
        List<SdeptTable> list = sdeptService.getByParent("02001");
        for (SdeptTable s : list){
            System.out.println(s);
        }
    }
}
