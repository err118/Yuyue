package com.yuyue.serviceImpl;

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

}
