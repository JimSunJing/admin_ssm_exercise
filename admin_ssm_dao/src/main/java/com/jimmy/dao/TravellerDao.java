package com.jimmy.dao;

import com.jimmy.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellerDao {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{oid})")
    List<Traveller> findByOrderId(int oid);

}
