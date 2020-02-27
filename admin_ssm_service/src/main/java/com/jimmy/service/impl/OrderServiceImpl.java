package com.jimmy.service.impl;

import com.jimmy.dao.OrderDao;
import com.jimmy.domain.Order;
import com.jimmy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    public List<Order> findAll() throws Exception {
        return orderDao.findAll();
    }
}
