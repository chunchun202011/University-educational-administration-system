package com.cy.school1.mapper;

import com.cy.school1.entity.SdeptTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Mapper
// @SpringBootTest:表示标注当前的类是一个测试类，不会随同项目一块打包发送
@SpringBootTest
// @RunWith:表示启动这个单元测试类(单元测试类是不能运行的)，需要传递一个参数，必须是SpringRunner的实例类型
@RunWith(SpringRunner.class)
public class SdeptMapperTests {

    //idea有检测的功能，接口是不能够直接创建Bean的(动态代理技术来解决)
    @Autowired(required = false)
    private SdeptMapper sdeptMapper;

    @Test
    public void findByParent(){
        List<SdeptTable> list = sdeptMapper.findByParent("02001");
        for(SdeptTable s : list){
            System.out.println(s);
        }
    }

    @Test
    public void findNameBySid(){
        String name = sdeptMapper.findNameBySid("001");
        System.out.println(name);
    }

//    @Test
//    public void selectAll() throws IOException {
////        List<SdeptTable> list = sdeptMapper.selectAll();
////        for(SdeptTable s : list){
////            System.out.println(s);
////        }
//        //1.加载MyBatis的核心配置文件，获取SqlSessionFactory
//        String resource = "mybatis-config.xml";
//        //返回字节输入流
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//
//        //2.获取SqlSession对象，用它执行sql
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        //3.获取SdeptMapper的代理对象
//        SdeptMapper sdeptMapper = sqlSession.getMapper(SdeptMapper.class);
//
//        //4.执行方法
//        List<SdeptTable> sdeptTables = sdeptMapper.selectAll();
//        System.out.println(sdeptTables);
//
//        //4.释放资源
//        sqlSession.close();
//    }
}
