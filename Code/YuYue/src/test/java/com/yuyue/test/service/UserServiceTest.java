package com.yuyue.test.service;

import org.apache.log4j.Logger;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yuyue.mapper.ServicesMapper;
import com.yuyue.mapper.UserMapper;
import com.yuyue.model.Services;
import com.yuyue.service.RecordService;
import com.yuyue.service.ServiceService;
import com.yuyue.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml", "classpath:spring-redis.xml"})
public class UserServiceTest {
	private static final Logger LOGGER = Logger.getLogger(UserServiceTest.class);
	@Autowired
	UserService userService;
	@Test
	public void testGetStaffs() {
		LOGGER.debug(JSONObject.toJSONString(userService.getStaffs(1L)));
	}
}
