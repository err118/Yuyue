package com.yuyue.test.dao;

import org.apache.log4j.Logger;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yuyue.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" ,"classpath:spring-redis.xml" })
public class UserMappperTest {
	private static final Logger LOGGER = Logger
			.getLogger(UserMappperTest.class);
	@Autowired
	UserMapper userMapper;

	@Test
	public void testSelectByWxId() {
	LOGGER.debug(JSONObject.toJSONString(userMapper.selectByWxId("wxid1"), SerializerFeature.WriteMapNullValue));
	}
	@Test
	public void testJoinShop() {
	LOGGER.debug(JSONObject.toJSONString(userMapper.joinShop(1, 1)));
	}	
	@Test
	public void testLeaveShop() {
	LOGGER.debug(JSONObject.toJSONString(userMapper.leaveShop("token1")));
	}
}
