package com.cy.school1.mapper;

import com.cy.school1.entity.News;
import com.cy.school1.vo.CourseVO;

import java.util.List;


public interface NewsMapper {
    Integer insertNews(News news);

    News findNewsByNid(Integer nid);

    Integer updateNews(News news);

    Integer deleteNews(Integer nid);

    List<News> findNewsList();
}
