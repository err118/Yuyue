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
import com.mysql.fabric.Server;
import com.yuyue.annotation.NoAuthorization;
import com.yuyue.model.ApiResponse;
import com.yuyue.model.Orders;
import com.yuyue.model.Services;
import com.yuyue.model.User;
import com.yuyue.model.UserRecord;
import com.yuyue.service.OrdersService;
import com.yuyue.service.RecordService;
import com.yuyue.service.ServiceService;
import com.yuyue.service.UserService;

@Controller
public class PayController {
	@Autowired
	OrdersService orderService;
	@Autowired
	UserService userService;
	@Autowired
	ServiceService serviceService;
	@Autowired
	RecordService recordService;
	final static Logger logger = LoggerFactory.getLogger(PayController.class);

	// 订单支付
	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	public @ResponseBody ApiResponse payOrder(@RequestParam String tokenId, @RequestBody String body) {
		User user = userService.getUserByToken(tokenId);
		JSONObject bodyObj = JSONObject.parseObject(body);
		if (user != null) {
			long userId = user.getId();
			long orderId = bodyObj.getLongValue("orderId");
			Orders order = orderService.getPayOrder(userId, orderId);
			if (order != null) {
				int status = doPay(order);
				if (status == 0) {
					// 支付成功后记录表中插入一条记录，并给服务者分成
					Long serverId = order.getServerId();
					UserRecord userRecord = new UserRecord();
					userRecord.setUserId(serverId);
					userRecord.setOrderNo(order.getOrderNo());
					userRecord.setOrderId(orderId);
					int recordStatus = recordService.addUserRecord(userRecord);
					User server = userService.selectUserByPrimaryKey(serverId);
					server.setMoney(server.getMoney() + order.getTotalPrice());
					userService.updateUserInfo(server);
				}
				return ApiResponse.successMessage("支付成功", "");
			}
			return ApiResponse.failMessage("支付失败");
		} else {
			return ApiResponse.failMessage("支付失败");
		}
	}

	private int doPay(Orders order) {
		return 0;
	}
}
