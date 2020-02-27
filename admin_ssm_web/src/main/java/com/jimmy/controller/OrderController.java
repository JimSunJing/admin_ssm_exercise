package com.jimmy.controller;

import com.jimmy.domain.Order;
import com.jimmy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();

        List<Order> all = service.findAll();
        System.out.println(all);
        mv.addObject("orderList",all);
        mv.setViewName("orderList");

        return mv;
    }
}
