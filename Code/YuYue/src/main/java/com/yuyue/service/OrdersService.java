package com.yuyue.service;

import org.springframework.core.annotation.Order;

public interface OrdersService {
	int submitOrder(Order order);
}
