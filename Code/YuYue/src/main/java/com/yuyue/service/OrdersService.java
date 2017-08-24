package com.yuyue.service;

import java.util.List;

import com.yuyue.model.Orders;

public interface OrdersService {
	int submitOrder(Orders order);
	int deleteOrder(long userId, long orderId);
	List<Orders> getMyOrder(long userId);
	Orders getPayOrder(long userId, long orderId);
}
