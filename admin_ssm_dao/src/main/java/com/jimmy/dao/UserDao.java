package com.jimmy.dao;

import com.jimmy.domain.UserInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {

    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "PASSWORD"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "STATUS"),
            @Result(property = "roles",column = "id", javaType = List.class,
                many = @Many(select = "com.jimmy.dao.RoleDao.findRoleByUid"))
    })
    UserInfo findByUsername(String username) throws Exception;

}
