package com.yuyue.service;

import java.util.List;

import com.yuyue.model.User;

public interface UserService {
	
	User wxLogin(String wxCode);
	int joinShop(long userId, long shopId);
	User getUserByToken(String tokenId);
	User selectUserByPrimaryKey(long id);
	int updateUserInfo(User user);
	List<User> getStaffs(Long shopId);
}