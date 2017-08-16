package com.yuyue.test.dao;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml", "classpath:spring-redis.xml"})
public class ServiceMappperTest {
	private static final Logger LOGGER = Logger.getLogger(ServiceMappperTest.class);
	@Autowired
	ServicesMapper serviceMapper;

	@Test
	public void testSelectIndexServceWithUser() {
		LOGGER.debug(JSONObject.toJSONString(serviceMapper.selectIndexServiceWithUser(),
				SerializerFeature.WriteMapNullValue));
	}
	@Test
	public void testInsertServce() {
		Services service = new Services();
		service.setTitle("服务添加测试");
		service.setPrice(798f);
		service.setCategoryId(1L);
		LOGGER.debug(JSONObject.toJSONString(serviceMapper.insert(service)));
	}
	@Test
	public void testSelectServceByUserId() {
		LOGGER.debug(JSONObject.toJSONString(serviceMapper.selectServiceByUserId(1),
				SerializerFeature.WriteMapNullValue));
	}
	@Test
	public void testDeleteByUserId() {
		LOGGER.debug(serviceMapper.deleteByUserId(1, 1));
	}
}
