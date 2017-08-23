package com.yuyue.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuyue.mapper.OrdersMapper;
import com.yuyue.model.Orders;
import com.yuyue.service.OrdersService;

@Service
public class OrdersServiceImp implements OrdersService {
	@Autowired
	private OrdersMapper orderMapper;
	@Override
	public int submitOrder(Orders order) {
		// TODO Auto-generated method stub
		return orderMapper.insert(order);
	}
	@Override
	public int deleteOrder(long userId, long orderId) {
		// TODO Auto-generated method stub
		return orderMapper.deleteOrder(userId, orderId);
	}
	@Override
	public Orders getMyOrder(long userId) {
		// TODO Auto-generated method stub
		return orderMapper.getOrdersByUserId(userId);
	}
	@Override
	public Orders getPayOrder(long userId, long orderId) {
		// TODO Auto-generated method stub
		return orderMapper.getPayOrder(userId, orderId);
	}

}
