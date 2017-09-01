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
import com.yuyue.model.User;
import com.yuyue.service.RecordService;
import com.yuyue.service.ServiceService;
import com.yuyue.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml",
		"classpath:spring-redis.xml" })
public class UserServiceTest {
	private static final Logger LOGGER = Logger.getLogger(UserServiceTest.class);
	@Autowired
	UserService userService;

	@Test
	public void testGetStaffs() {
		LOGGER.debug(JSONObject.toJSONString(userService.getStaffs(1L)));
	}

	@Test
	public void testUpdateUserInfo() {
		User user = new User();
		user.setId(1L);
		JSONObject obj = new JSONObject();
		obj.put("imageContent",
				"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"
				+ "ErkJggg==");
		LOGGER.debug(userService.updateUserInfo(obj, user));
	}
}
