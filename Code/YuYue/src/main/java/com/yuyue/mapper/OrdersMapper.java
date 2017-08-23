package com.yuyue.mapper;

import org.apache.ibatis.annotations.Param;

import com.yuyue.model.Orders;

public interface OrdersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
//    以下为新增,
    int deleteOrder(@Param(value = "userId") long userId,@Param(value = "orderId") long orderId);
    Orders getOrdersByUserId(@Param(value = "userId") long userId);
    Orders getPayOrder(@Param(value = "userId") long userId,@Param(value = "orderId") long orderId); 
}