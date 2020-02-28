package com.jimmy.dao;

import com.jimmy.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

    @Select("select * from users where username = #{username}")
    @Results(id = "userResultMap",value = {
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

    @Select("select * from users")
//    @ResultMap("userResultMap")
    List<UserInfo> findAll() throws Exception;

    @Select("select * from users where id = #{uid}")
    @ResultMap("userResultMap")
    UserInfo findById(int uid) throws Exception;

    @Insert("insert into users (email,username,PASSWORD,phoneNum,STATUS) " +
            "values (#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo info)throws Exception;

    @Insert("insert into users_role (userId,roleId) values (#{uid}, #{rid})")
    void addRoleToUser(@Param("uid") int uid, @Param("rid") int rid);
}
