package com.jimmy.dao;

import com.jimmy.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoleDao {

    @Select("select * from role where id in (select roleId from users_role where userId = #{uid})")
    @Results(id = "roleResultMap",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = List.class,
                many = @Many(select = "com.jimmy.dao.PermissionDao.findByRoleId"))
    })
    List<Role> findRoleByUid(int uid) throws Exception;

    @Select("select * from role")
    List<Role> findAll() throws Exception;

    @Insert("insert into role (roleName,roleDesc) values (#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from role where id = #{id}")
    @ResultMap("roleResultMap")
    Role findById(int id);

    @Delete("delete from role where id = #{id}")
    void deleteById(int id);
}
