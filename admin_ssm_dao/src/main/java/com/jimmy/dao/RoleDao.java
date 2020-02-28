package com.jimmy.dao;

import com.jimmy.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleDao {

    @Select("select * from role where id in (select roleId from users_role where userId = #{uid})")
    List<Role> findRoleByUid(int uid) throws Exception;
}
