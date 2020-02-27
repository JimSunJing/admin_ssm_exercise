package com.jimmy.dao;

import com.jimmy.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDao {

    /**
     * 查询所有的商品信息
     * @return
     */
    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    /**
     * 添加商品
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) " +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void addProduct(Product product);

    /**
     * 根据id返回商品
     * @param id
     * @return
     */
    @Select("select * from product where id = #{id}")
    Product findById(int id);
}
