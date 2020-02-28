package com.jimmy.service;

import com.jimmy.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<UserInfo> findAll() throws Exception;

    UserInfo findById(int uid)throws Exception;

    void save(UserInfo info) throws Exception;

    void addRoleToUser(int uid, int rid);
}
