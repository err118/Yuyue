package com.yuyue.service;

import com.yuyue.model.User;

public interface UserService {
	
	User wxLogin(String wxCode);
}