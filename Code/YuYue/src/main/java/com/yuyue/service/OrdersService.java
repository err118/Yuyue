package com.yuyue.service;

import com.yuyue.model.Orders;

public interface OrdersService {
	int submitOrder(Orders order);
	int deleteOrder(long userId, long orderId);
	Orders getMyOrder(long userId);
	Orders getPayOrder(long userId, long orderId);
}
