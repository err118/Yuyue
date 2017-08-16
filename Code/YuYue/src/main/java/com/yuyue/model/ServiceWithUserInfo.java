package com.yuyue.model;

public class ServiceWithUserInfo extends Services {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 个人信息部分
	private String avatarUrl;
	private String nickname;
	// 店铺信息
	private String shopName;

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
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
