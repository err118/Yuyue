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
import com.yuyue.model.Orders;
import com.yuyue.model.Services;
import com.yuyue.model.User;
import com.yuyue.service.OrdersService;
import com.yuyue.service.ServiceService;
import com.yuyue.service.UserService;

@Controller
public class OrderController {
	@Autowired
	OrdersService orderService;
	@Autowired
	UserService userService;
	@Autowired
	ServiceService serviceService;
	final static Logger logger = LoggerFactory.getLogger(OrderController.class);

	// 客户提交订单
	@RequestMapping(value = "/order/submitOrder", method = RequestMethod.POST)
	public @ResponseBody ApiResponse submitOrder(@RequestParam String tokenId, @RequestBody String body) {
		JSONObject bodyObj = JSONObject.parseObject(body);
		User user = userService.getUserByToken(tokenId);
		if (user != null) {
			long userId = user.getId();
			Long serviceId = bodyObj.getLongValue("serviceId");
			String remarks = bodyObj.getString("remarks");
			int quantity = bodyObj.getIntValue("quantity");
			Services services = serviceService.getService(serviceId);
			String servicesTitle = services.getTitle();
			Float servicePrice = services.getPrice();
			Long serverId = services.getUserId();
			User server = userService.selectUserByPrimaryKey(serverId);
			String serverName = server.getNickname();
			Float amount = quantity * servicePrice;
			Orders order = new Orders();
			order.setUserId(userId);
			order.setServiceId(serviceId);
			order.setServiceTitle(servicesTitle);
			order.setServerId(serverId);
			order.setServerName(serverName);
			order.setRemark(remarks);
			order.setTotalPrice(amount);
			int status = orderService.submitOrder(order);
			if (status > 0) {
				return ApiResponse.successMessage("提交订单成功", "");
			} else
				return ApiResponse.successMessage("提交订单失败", "");
		} else {
			return ApiResponse.successMessage("提交订单失败", "");
		}
	}

	// 客户删除订单
	@RequestMapping(value = "/order/deleteOrder", method = RequestMethod.POST)
	public @ResponseBody ApiResponse deleteOrder(@RequestParam String tokenId, @RequestBody String body) {
		JSONObject bodyObj = JSONObject.parseObject(body);
		User user = userService.getUserByToken(tokenId);
		if (user != null) {
			long userId = user.getId();
			long orderId = bodyObj.getLongValue("orderId");
			int status = orderService.deleteOrder(userId, orderId);
			if (status > 0) {
				return ApiResponse.successMessage("删除订单成功", "");
			} else
				return ApiResponse.successMessage("删除订单失败", "");
		} else {
			return ApiResponse.successMessage("删除订单失败", "");
		}
	}

	// 客户获取自己下过的订单
	@RequestMapping(value = "/order/getMyOrder", method = RequestMethod.POST)
	public @ResponseBody ApiResponse getMyOrder(@RequestParam String tokenId) {
		User user = userService.getUserByToken(tokenId);
		if (user != null) {
			long userId = user.getId();
			List<Orders> orders = orderService.getMyOrder(userId);
			return ApiResponse.successMessage("获取订单成功", orders);
		} else {
			return ApiResponse.successMessage("获取订单失败", "");
		}
	}
}
