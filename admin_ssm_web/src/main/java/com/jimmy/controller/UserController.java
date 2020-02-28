package com.jimmy.controller;

import com.jimmy.domain.Role;
import com.jimmy.domain.UserInfo;
import com.jimmy.service.RoleService;
import com.jimmy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();

        List<UserInfo> all = userService.findAll();
        mv.addObject("userList",all);
        mv.setViewName("user-list");

        return mv;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(int id)throws Exception{
        ModelAndView mv = new ModelAndView();

        UserInfo userInfo = userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");

        return mv;
    }

    @RequestMapping("/save")
    public String save(UserInfo info) throws Exception {
        userService.save(info);
        // 重新查询一次
        return "redirect:findAll";
    }

    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(int id) throws Exception {
        ModelAndView mv = new ModelAndView();
        // 获取用户
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user",userInfo);
        // 获取角色列表
        List<Role> roleList = roleService.findAll();
        mv.addObject("roleList",roleList);
        // 转到添加页面
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(
            @RequestParam(name = "userId", required = true)int userId,
            @RequestParam(name = "ids", required = true)List<Integer> ids) throws Exception {
        // 获取用户
        UserInfo userInfo = userService.findById(userId);
        Set<Integer> had = new HashSet<>();
        List<Role> roles = userInfo.getRoles();
        for (Role role : roles){
            had.add((Integer) role.getId());
        }
        for (Integer id : ids) {
            if (had.contains(id)) continue;
            userService.addRoleToUser(userId,id);
        }
        return "redirect:findAll";
    }

}
