package com.jimmy.controller;

import com.jimmy.domain.Role;
import com.jimmy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:findAll";
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();

        List<Role> all = roleService.findAll();
        mv.addObject("roleList",all);
        mv.setViewName("role-list");

        return mv;
    }

    @RequestMapping("findById")
    public ModelAndView findById(int id){
        ModelAndView mv = new ModelAndView();

        Role role = roleService.findById(id);
        mv.addObject("role",role);
        mv.setViewName("role-show");

        return mv;
    }

    @RequestMapping("/delete")
    public String delete(int id){
        roleService.deleteById(id);
        return "redirect:findAll";
    }

}
