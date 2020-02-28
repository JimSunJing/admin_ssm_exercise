package com.jimmy.controller;

import com.jimmy.domain.Product;
import com.jimmy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/findAll")
//    @RolesAllowed("ADMIN")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> all = service.findAll();

        mv.addObject("productList",all);
        mv.setViewName("productList");
        return mv;
    }

    @RequestMapping("/addProduct")
    public String addProduct(Product product){
        System.out.println(product);
        service.addProduct(product);
        return "redirect:findAll";
    }

    /*@RequestMapping("/addProduct")
    public String addProduct(HttpServletRequest request){
        System.out.println(request.getParameter("departureTime"));
        return "redirect:findAll";
    }*/

}
