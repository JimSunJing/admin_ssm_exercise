package com.jimmy.service;

import com.jimmy.domain.Order;

import java.util.List;

public interface OrderService{

    List<Order> findAll() throws Exception;

    List<Order> findAllByPage(int start,int size) throws Exception;

    Order findById(int oid) throws Exception;
}
