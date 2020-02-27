package com.jimmy.dao;

import com.jimmy.domain.Order;
import com.jimmy.domain.Product;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
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
            @Result(property = "orderStatus", column = "orderStatus")/*,
            @Result(property = "product", column = "productId",
                javaType = Product.class, one = @One(select = "com.jimmy.dao.ProductDao.findById"))*/
    })
    List<Order> findAll() throws Exception;
}
