package com.yuyue.service;

import java.util.List;

import com.yuyue.model.Shop;
import com.yuyue.model.User;

public interface ShopService {
	int createNewShop(Shop shop);
	int updateShopInfo(Shop shop);
}
