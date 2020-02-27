package com.jimmy.dao;

import com.jimmy.domain.Member;
import com.jimmy.domain.Order;
import com.jimmy.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrderDao {

    @Select("select * from orders")
    @Results({
            @Result(id=true,property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "product", column = "productId",
                javaType = Product.class, one = @One(select = "com.jimmy.dao.ProductDao.findById"))
    })
    List<Order> findAll() throws Exception;

    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id=true,property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "product", column = "productId",
                javaType = Product.class, one = @One(select = "com.jimmy.dao.ProductDao.findById")),
            @Result(property = "member", column = "memberId",
                javaType = Member.class, one = @One(select = "com.jimmy.dao.MemberDao.findById")),
            @Result(property = "travellers", column = "id",
                javaType = List.class, many = @Many(select = "com.jimmy.dao.TravellerDao.findByOrderId"))
    })
    Order findById(int id) throws Exception;
}
