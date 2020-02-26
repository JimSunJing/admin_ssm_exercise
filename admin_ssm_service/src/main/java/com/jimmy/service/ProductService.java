package com.jimmy.service;

import com.jimmy.domain.Product;

import java.util.List;

public interface ProductService {

    /**
     * 查询所有的商品信息
     * @return
     */
    public List<Product> findAll() throws Exception;
}
