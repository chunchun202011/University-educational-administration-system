package com.cy.school1.controller;

import com.cy.school1.entity.OrderItem;
import com.cy.school1.entity.SCOrder;
import com.cy.school1.service.IOrderService;
import com.cy.school1.util.JsonResult;
import com.cy.school1.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("orders")
@RestController
public class OrderController extends BaseController{
    @Autowired
    private IOrderService orderService;

    @RequestMapping("create")
    public JsonResult<SCOrder> create(HttpSession session,String[] cnos){
        String sno = getSnoFromSession(session);
        String sname = getSnameFromSession(session);
        SCOrder data = orderService.create(sno,sname,cnos);
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("list")
    public JsonResult<List<OrderVO>> findAllOrderItems(){
        List<OrderVO> data = orderService.findAllOrderItems();
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("find")
    public JsonResult<List<OrderVO>> findOrderItemsByScid(Integer scid){
        List<OrderVO> data = orderService.findOrderItemsByScid(scid);
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("condition")
    public JsonResult<List<OrderVO>> findByCondition(OrderVO orderVO){
        List<OrderVO> data = orderService.findByCondition(orderVO);
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("mine")
    public JsonResult<List<OrderVO>> findBySno(HttpSession session){
        String sno = getSnoFromSession(session);
        List<OrderVO> data = orderService.findBySno(sno);
        return new JsonResult<>(OK,data);
    }


}
