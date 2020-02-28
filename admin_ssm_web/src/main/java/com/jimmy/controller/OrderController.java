package com.jimmy.controller;

import com.github.pagehelper.PageInfo;
import com.jimmy.domain.Order;
import com.jimmy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    /*@RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();

        List<Order> all = service.findAll();
        System.out.println(all);
        mv.addObject("orderList",all);
        mv.setViewName("orderList");
        return mv;
    }*/

    /**
     * 带分页功能
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll")
//    @Secured("ROLE_ADMIN") // jsr250可省略role_前缀，但secured不能省略
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView findAll(
            @RequestParam(name = "page",defaultValue = "1")int page,
            @RequestParam(name = "pageSize",defaultValue = "5")int pageSize) throws Exception {
        ModelAndView mv = new ModelAndView();

        List<Order> all = service.findAllByPage(page,pageSize);
        // 封装的一个对象，包含查询出来的list以及分页的数据
        PageInfo pageInfo = new PageInfo(all);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orderListPage");
        return mv;
    }

    @RequestMapping("/findById")
    @PreAuthorize("authentication.principal.username == 'tom'") // 只有tom可以使用
    public ModelAndView findById(@RequestParam(name = "orderId", required = true)int oid) throws Exception{
        ModelAndView mv = new ModelAndView();

        Order order = service.findById(oid);

        mv.addObject("order",order);
        mv.setViewName("orderShow");

        return mv;
    }
}
