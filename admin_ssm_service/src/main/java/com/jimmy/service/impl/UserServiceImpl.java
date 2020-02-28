package com.jimmy.service.impl;

import com.jimmy.dao.UserDao;
import com.jimmy.domain.Role;
import com.jimmy.domain.UserInfo;
import com.jimmy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 处理好验证过程并包装成指定的对象
        User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),
                userInfo.getStatus()==1 ? true:false,true,true,true,
                getAuthorities(userInfo.getRoles()));

        return user;
    }

    public Collection getAuthorities(List<Role> roles){
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return authorities;
    }
}
