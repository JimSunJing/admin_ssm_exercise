package com.jimmy.service.impl;

import com.jimmy.dao.ProductDao;
import com.jimmy.domain.Product;
import com.jimmy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    public void addProduct(Product product) {
        productDao.addProduct(product);
    }


}
