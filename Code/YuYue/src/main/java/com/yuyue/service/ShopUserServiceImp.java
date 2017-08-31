package com.yuyue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuyue.mapper.ShopUserMapper;

@Service
public class ShopUserServiceImp implements ShopUserService {
	@Autowired
	ShopUserMapper shopUserMapper;
	@Override
	public int deleteFreeStaff(long userId,long shopId) {
		// TODO Auto-generated method stub
		return shopUserMapper.deleteStaff(userId, shopId);
	}

}
