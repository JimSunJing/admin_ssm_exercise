package com.jimmy.service;

import com.jimmy.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    void save(Role role);

    Role findById(int id);

    void deleteById(int id);

}
