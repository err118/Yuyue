package com.yuyue.test.dao;

import org.apache.commons.collections.OrderedMap;
import org.apache.log4j.Logger;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yuyue.mapper.OrdersMapper;
import com.yuyue.mapper.ServiceMapper;
import com.yuyue.mapper.UserMapper;
import com.yuyue.model.Orders;
import com.yuyue.model.Service;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class OrdersMappperTest {
	private static final Logger LOGGER = Logger.getLogger(OrdersMappperTest.class);
	@Autowired
	OrdersMapper ordersMapper;

	@Test
	public void testInsertOrders() {
		Orders orders = new Orders();
		LOGGER.debug(JSONObject.toJSONString(ordersMapper.insert(orders)));
	}
}
