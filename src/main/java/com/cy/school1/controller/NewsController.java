package com.cy.school1.controller;

import com.cy.school1.entity.News;
import com.cy.school1.service.INewsService;
import com.cy.school1.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("news")
public class NewsController extends BaseController{
    @Autowired(required = false)
    private INewsService newsService;

    @RequestMapping("add")
    public JsonResult<Integer> insertNews(HttpSession session, News news){
        String mno = getMnoFromSession(session);
        Integer data = newsService.insertNews(mno,news);
        return new JsonResult<Integer>(OK,data);
    }

    @RequestMapping("details")
    public JsonResult<News> findNewsByNid(Integer nid){
        //调用业务对象执行获取数据
       News data = newsService.findNewsByNid(nid);
        //返回成功和数据
        return new JsonResult<News>(OK,data);
    }

    @RequestMapping("update")
    public JsonResult<Integer> updateNews(HttpSession session,News news){
        String mno = getMnoFromSession(session);
        Integer data = newsService.updateNews(mno,news);
        //返回成功和数据
        return new JsonResult<Integer>(OK,data);
    }

    @RequestMapping("delete")
    public JsonResult<Integer> deleteNews(Integer nid){
        Integer data = newsService.deleteNews(nid);
        //返回成功和数据
        return new JsonResult<Integer>(OK,data);
    }

    @RequestMapping("list")
    public JsonResult<List<News>> findNewsList(){
        List<News> data = newsService.findNewsList();
        //返回成功和数据
        return new JsonResult<List<News>>(OK,data);
    }



}
