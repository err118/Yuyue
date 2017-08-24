package com.yuyue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yuyue.annotation.NoAuthorization;
import com.yuyue.cache.redis.TokenManager;
import com.yuyue.mapper.UserMapper;
import com.yuyue.model.ApiResponse;
import com.yuyue.model.ServiceWithUserInfo;
import com.yuyue.model.Services;
import com.yuyue.model.User;
import com.yuyue.service.ServiceService;
import com.yuyue.service.UserService;

@Controller
public class ServiceController {
	@Autowired
	ServiceService serviceService;
	@Autowired
	UserService userService;

	@NoAuthorization
	@RequestMapping(value = "/service/getIndexUser", method = RequestMethod.GET)
	public @ResponseBody List<ServiceWithUserInfo> getIndexUser() {
		return serviceService.getIndexUser();
	}

	@RequestMapping(value = "/service/publishService", method = RequestMethod.POST)
	public @ResponseBody ApiResponse publishServie(@RequestParam String tokenId, @RequestBody String body) {
		JSONObject obj = new JSONObject();
		JSONObject bodyObj = JSONObject.parseObject(body);
		long categoryId = bodyObj.getLongValue("categoryId");
		String title = bodyObj.getString("title");
		String content = bodyObj.getString("content");
		Float price = bodyObj.getFloatValue("price");
		User user = userService.getUserByToken(tokenId);
		Services services = new Services();
		services.setCategoryId(categoryId);
		services.setTitle(title);
		services.setContent(content);
		services.setPrice(price);
		services.setUserId(user.getId());
		services.setStatus(1);
		int status = serviceService.publishService(services);
		if (status > 0) {
			return ApiResponse.successMessage("发布成功", "");
		}
		return ApiResponse.failMessage("发布失败");
	}

	@RequestMapping(value = "/service/deleteService", method = RequestMethod.POST)
	public @ResponseBody ApiResponse deleteServie(@RequestParam String tokenId, @RequestBody String body) {
		JSONObject obj = new JSONObject();
		JSONObject bodyObj = JSONObject.parseObject(body);
		User user = userService.getUserByToken(tokenId);
		long serviceId = bodyObj.getLongValue("serviceId");
		int status = serviceService.deleteService(serviceId, user.getId());
		if (status > 0) {
			return ApiResponse.successMessage("发布成功", "");
		}
		return ApiResponse.failMessage("发布失败");
	}
}
