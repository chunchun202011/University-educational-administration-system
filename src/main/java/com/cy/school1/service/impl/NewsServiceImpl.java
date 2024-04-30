package com.cy.school1.service.impl;

import com.cy.school1.entity.News;
import com.cy.school1.mapper.NewsMapper;
import com.cy.school1.service.INewsService;
import com.cy.school1.service.ex.DeleteException;
import com.cy.school1.service.ex.InsertException;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
/* 新闻业务 */
public class NewsServiceImpl implements INewsService {

    @Autowired
    private NewsMapper newsMapper;


    @Override
    public Integer insertNews(String mno, News news) {
        if (news!= null){
            news.setCreatedUser(mno);
            news.setCreatedTime(new Date());
            news.setModifiedUser(mno);
            news.setModifiedTime(new Date());
        }
        Integer rows = newsMapper.insertNews(news);
        if (rows<=0){
            throw new InsertException("插入新闻产生未知的异常！");
        }
        return rows;
    }

    @Override
    public News findNewsByNid(Integer nid) {
        News news = newsMapper.findNewsByNid(nid);
        return news;
    }

    @Override
    public Integer updateNews(String mno,News news) {
        if (news!=null){
            news.setModifiedUser(mno);
            news.setModifiedTime(new Date());
        }
        Integer rows = newsMapper.updateNews(news);
        return rows;
    }

    @Override
    public Integer deleteNews(Integer nid) {
        Integer rows = newsMapper.deleteNews(nid);
        if (rows <= 0){
            throw new DeleteException("删除新闻失败！");
        }
        return rows;
    }

    @Override
    public List<News> findNewsList() {
        List<News> list = newsMapper.findNewsList();
        return list;
    }
}
