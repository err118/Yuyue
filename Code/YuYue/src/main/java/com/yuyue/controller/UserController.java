package com.yuyue.controller;

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
import com.yuyue.model.User;
import com.yuyue.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	final static Logger logger = LoggerFactory.getLogger(UserController.class);

	@NoAuthorization
	@RequestMapping(value = "/user/wxLogin/{code}", method = RequestMethod.GET)
	public @ResponseBody ApiResponse wxLogin(@PathVariable String code) {
		User user = userService.wxLogin(code);
		return ApiResponse.successMessage("登录成功", user);
	}

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

	@RequestMapping(value = "/user/updateUserInfo", method = RequestMethod.POST)
	public @ResponseBody ApiResponse updateuserInfo(@PathVariable String tokenId, @RequestBody String body) {
		User user = userService.getUserByToken(tokenId);
		JSONObject bodyObj = JSONObject.parseObject(body);
		if (user != null) {
			long id = user.getId();
			String nickname = bodyObj.getString("nickname");
			if (!"".equals(nickname))
				user.setNickname(nickname);
			int status = userService.updateUserInfo(user);
			if(status > 0){
				return ApiResponse.successMessage("更新成功","");
			}
			else {
				return ApiResponse.failMessage("更新失败");
			}

		} else {
			return ApiResponse.failMessage("无此用户");
		}
	}
}
