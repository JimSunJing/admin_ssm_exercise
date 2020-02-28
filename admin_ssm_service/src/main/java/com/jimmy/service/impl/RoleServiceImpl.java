package com.jimmy.service.impl;

import com.jimmy.dao.RoleDao;
import com.jimmy.domain.Role;
import com.jimmy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    public List<Role> findAll() {
        List<Role> list = null;
        try {
            list =  roleDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void save(Role role) {
        roleDao.save(role);
    }

    public Role findById(int id) {
        return roleDao.findById(id);
    }

    public void deleteById(int id) {
        roleDao.deleteById(id);
    }

}
