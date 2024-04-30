package com.cy.school1.mapper;

import com.cy.school1.entity.Course;
import com.cy.school1.entity.News;
import com.cy.school1.vo.CourseVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class NewsMapperTests {

    @Autowired
    private NewsMapper newsMapper;

    @Test
    public void insertNews(){
        News news = new News();
        String title="人民的民意";
        news.setTitle(title);
        String content="人民的民意";
        news.setCreatedUser("管理员");
        news.setCreatedTime(new Date());
        news.setModifiedUser("管理员");
        news.setModifiedTime(new Date());
        news.setContent(content);
        Integer rows = newsMapper.insertNews(news);
        System.out.println(rows);
    }

    @Test
    public void findNewsByNid(){
        News news = newsMapper.findNewsByNid(1);
        System.out.println(news.getTitle());
        System.out.println(news.getContent());
    }

    @Test
    public void updateNews(){
        News news = newsMapper.findNewsByNid(1);
        news.setTitle("心得体会");
        news.setContent("修改的新的");
        news.setModifiedUser("管理员");
        news.setModifiedTime(new Date());
        Integer rows = newsMapper.updateNews(news);
        System.out.println(rows);
    }

    @Test
    public void deleteNews(){
        Integer rows = newsMapper.deleteNews(2);
        System.out.println(rows);
    }

    @Test
    public void findNewsList(){
       List<News> list = newsMapper.findNewsList();
        System.out.println(list);
    }


}
