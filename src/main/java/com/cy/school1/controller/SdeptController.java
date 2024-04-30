package com.cy.school1.controller;

import com.cy.school1.entity.SdeptTable;
import com.cy.school1.service.ISdeptService;
import com.cy.school1.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("sdepts")
@RestController
public class SdeptController extends BaseController {
    @Autowired
    private ISdeptService sdeptService;

    //sdepts开头的请求都被拦截到getByParent()方法
    @RequestMapping({"/",""})
    public JsonResult<List<SdeptTable>> getByParent(String parent){
       List<SdeptTable> data =  sdeptService.getByParent(parent);
       return new JsonResult<>(OK,data);
    }

}
