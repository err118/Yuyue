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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml", "classpath:spring-redis.xml"})
public class RecordServiceTest {
	private static final Logger LOGGER = Logger.getLogger(RecordServiceTest.class);
	@Autowired
	RecordService recordService;
	@Test
	public void testgetRecord() {
		LOGGER.debug(JSONObject.toJSONString(recordService.getUserRecord(1)));
	}
}
