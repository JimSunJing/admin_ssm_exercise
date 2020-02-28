package com.jimmy.service;

import com.jimmy.domain.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> findAll();

    void save(Permission permission);
}
