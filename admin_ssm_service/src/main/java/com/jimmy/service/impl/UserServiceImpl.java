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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<UserInfo> findAll() throws Exception {
        return userDao.findAll();
    }

    public UserInfo findById(int uid) throws Exception {
        UserInfo user =userDao.findById(uid);
//        System.out.println(user.getRoles().get(0).getPermissions());
        return user;
    }

    public void save(UserInfo info) throws Exception {
        info.setPassword(passwordEncoder.encode(info.getPassword()));
        userDao.save(info);
    }

    public void addRoleToUser(int uid, int rid) {
        userDao.addRoleToUser(uid,rid);
    }


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 处理好验证过程并包装成指定的对象
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),
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
