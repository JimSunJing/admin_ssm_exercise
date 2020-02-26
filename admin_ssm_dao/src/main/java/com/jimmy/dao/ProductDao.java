package com.jimmy.dao;

import com.jimmy.domain.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDao {

    /**
     * 查询所有的商品信息
     * @return
     */
    @Select("select * from product")
    public List<Product> findAll() throws Exception;
}
