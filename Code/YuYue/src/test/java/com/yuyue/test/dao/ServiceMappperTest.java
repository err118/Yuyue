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
import com.yuyue.model.Service;

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
	@Test
	public void testInsertServce() {
		Service service = new Service();
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
}
