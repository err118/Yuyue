package com.yuyue.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.yuyue.mapper.ShopMapper;
import com.yuyue.model.Shop;
import com.yuyue.service.ShopService;

public class ShopServiceImp implements ShopService {

	@Autowired
	ShopMapper shopMapper;

	@Override
	public int createNewShop(Shop shop) {
		// TODO Auto-generated method stub
		return shopMapper.insert(shop);
	}

	@Override
	public int updateShopInfo(Shop shop) {
		// TODO Auto-generated method stub
		return shopMapper.updateByPrimaryKey(shop);
	}

}
