package com.cy.school1.service;

import com.cy.school1.entity.News;

import java.util.List;


public interface INewsService {

    Integer insertNews(String mno,News news);

    News findNewsByNid(Integer nid);

    Integer updateNews(String mno,News news);

    Integer deleteNews(Integer nid);

    List<News> findNewsList();
}
