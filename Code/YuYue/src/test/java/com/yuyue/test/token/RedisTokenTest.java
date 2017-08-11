package com.yuyue.test.token;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yuyue.cache.redis.TokenManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-redis.xml", "classpath:spring-mybatis.xml" })
public class RedisTokenTest {
	private static final Logger LOGGER = Logger.getLogger(RedisTokenTest.class);
	@Autowired
	private TokenManager manager;

	@Test
	public void testRedisTokenCreate() {
		LOGGER.debug(JSONObject.toJSONString(manager.createToken(1),
				SerializerFeature.WriteMapNullValue));
	}

//	@Test
//	public void testRedisTokenGet() {
//		LOGGER.debug(JSONObject.toJSONString(manager.getToken(1),
//				SerializerFeature.WriteMapNullValue));
//	}

	@Test
	public void testRedisTokenCheck() {
		LOGGER.debug(manager.getTokenFromRedis(1));
	}
	@Test
	public void testRedisTokenDelete() {
		manager.deleteToken(1);
		LOGGER.debug(manager.getTokenFromRedis(1));
	}
}
