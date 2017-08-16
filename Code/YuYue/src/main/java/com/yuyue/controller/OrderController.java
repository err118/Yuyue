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
import com.yuyue.model.Orders;
import com.yuyue.model.User;
import com.yuyue.service.OrdersService;
import com.yuyue.service.UserService;

@Controller
public class OrderController {
	@Autowired
	OrdersService orderService;
	@Autowired
	UserService userService;
	final static Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@RequestMapping(value = "/order/submitOrder", method = RequestMethod.POST)
	public @ResponseBody ApiResponse submitOrder(@RequestParam String tokenId ,@RequestBody String body){
		JSONObject bodyObj =  JSONObject.parseObject(body);
		User user = userService.getUserByToken(tokenId);
		if(user != null){
			long userId = user.getId();
			String serviceTitle = bodyObj.getString("serviceTitle");
			Long serverId = bodyObj.getLongValue("serverId");
			String serverName = bodyObj.getString("serverName");
			Float servicePrice = bodyObj.getFloatValue("servicePrice");
			String remarks = bodyObj.getString("remarks");
			Float amount = bodyObj.getFloatValue("amount");
			Orders order = new Orders();
			order.setUserId(userId);
			order.setServiceTitle(serviceTitle);
			order.setServiceId(serverId);
			order.setServerId(serverId);
			order.setRemark(remarks);
			order.setTotalPrice(amount);
			int status = orderService.submitOrder(order);
			if(status > 0){
				return ApiResponse.successMessage("提交订单成功", "");
			}
			else return ApiResponse.successMessage("提交订单失败", "");
		}
		else {
			 return ApiResponse.successMessage("提交订单失败", "");
		}
	}
}
