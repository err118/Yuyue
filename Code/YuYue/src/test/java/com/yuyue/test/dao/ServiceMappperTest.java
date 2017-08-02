package com.yuyue.test.dao;

import org.apache.log4j.Logger;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yuyue.mapper.ServiceMapper;
import com.yuyue.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class ServiceMappperTest {
	private static final Logger LOGGER = Logger.getLogger(ServiceMappperTest.class);
	@Autowired
	ServiceMapper serviceMapper;

	@Test
	public void testSelectIndexServceWithUser() {
		LOGGER.debug(JSONObject.toJSONString(serviceMapper.selectIndexServiceWithUser(),
				SerializerFeature.WriteMapNullValue));
	}
}
