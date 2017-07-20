package com.yuyue.test.dao;

import org.apache.log4j.Logger;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.yuyue.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class UserMappperTest {
	private static final Logger LOGGER = Logger
			.getLogger(UserMappperTest.class);
	@Autowired
	UserMapper userMapper;

	@Test
	public void testSelectByWxId() {
	LOGGER.debug(JSONObject.toJSON(userMapper.selectByWxId("wxid1")));
	}
}
