package com.yuyue.model;

public class ServiceWithUserInfo extends Service {
	// 个人信息部分
	private String imageUrl;
	private String nickname;
	// 店铺信息
	private String shopName;

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
}
