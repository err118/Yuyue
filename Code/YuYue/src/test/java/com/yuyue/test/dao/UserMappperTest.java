package com.yuyue.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yuyue.mapper.UserMapper;
import com.yuyue.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class UserMappperTest {
	@Autowired
	UserMapper userMapper;

	@Test
	public void testSelectByWxId() {
		User user = userMapper.selectByWxId("111");
		if (user == null) {
			System.out.println("user null");
		} else {
			System.out.println(user.toString());
		}
	}
}
