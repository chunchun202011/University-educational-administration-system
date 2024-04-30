package com.cy.school1.service;

import com.cy.school1.entity.Course;
import com.cy.school1.entity.News;
import com.cy.school1.vo.CourseVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@MapperScan("com.cy.school1.mapper")
@SpringBootTest
@RunWith(SpringRunner.class)
public class NewsServiceTests {

    @Autowired
    private INewsService newsService;

    @Test
    public void updateNews(){
        News news = new News();
        news.setNid(1);
        news.setTitle("lalala");
        news.setContent("hahaha");
        newsService.updateNews("521",news);
    }

    @Test
    public void deleteNews(){
       newsService.deleteNews(4);
    }
}
