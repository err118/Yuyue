package com.yuyue.controller;

import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yuyue.annotation.NoAuthorization;
import com.yuyue.model.ApiResponse;
import com.yuyue.model.Staff;
import com.yuyue.model.User;
import com.yuyue.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	final static Logger logger = LoggerFactory.getLogger(UserController.class);

	// 微信登录
	@NoAuthorization
	@RequestMapping(value = "/user/wxLogin/{code}", method = RequestMethod.GET)
	public @ResponseBody ApiResponse wxLogin(@PathVariable String code) {
		User user = userService.wxLogin(code);
		return ApiResponse.successMessage("登录成功", user);
	}

	// 自由服务者或者用户加入店铺
	@RequestMapping(value = "/user/joinShop", method = RequestMethod.POST)
	public @ResponseBody ApiResponse joinShop(@RequestParam String tokenId, @RequestBody String body) {
		User user = userService.getUserByToken(tokenId);
		JSONObject bodyObj = JSONObject.parseObject(body);
		long shopId = bodyObj.getIntValue("shopId");
		long userId = user.getId();
		int status = userService.joinShop(userId, shopId);
		if (status > 0) {
			return ApiResponse.successMessage("加入成功", "");
		} else {
			return ApiResponse.successMessage("加入失败", "");
		}
	}

	// 更新用户信息
	@RequestMapping(value = "/user/updateUserInfo", method = RequestMethod.POST)
	public @ResponseBody ApiResponse updateuserInfo(@PathVariable String tokenId, @RequestBody String body) {
		User user = userService.getUserByToken(tokenId);
		JSONObject bodyObj = JSONObject.parseObject(body);
		if (user != null) {
			int status = userService.updateUserInfo(bodyObj, user);
			if (status > 0) {
				return ApiResponse.successMessage("更新成功", "");
			} else {
				return ApiResponse.failMessage("更新失败");
			}

		} else {
			return ApiResponse.failMessage("无此用户");
		}
	}

	// 店铺获取加入店铺的自由服务者
	@RequestMapping(value = "/user/getStaff", method = RequestMethod.POST)
	public @ResponseBody ApiResponse getStaff(@RequestParam String tokenId, @RequestBody String body) {
		JSONObject bodyObj = new JSONObject();
		long shopId = bodyObj.getIntValue("shopId");
		List<User> staff = userService.getStaffs(shopId);
		return ApiResponse.successMessage("获取成功", staff);
	}
}
