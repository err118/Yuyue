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
import com.yuyue.model.UserRecord;
import com.yuyue.service.OrdersService;
import com.yuyue.service.RecordService;
import com.yuyue.service.ServiceService;
import com.yuyue.service.UserService;

@Controller
public class RecordController {
	final static Logger logger = LoggerFactory.getLogger(RecordController.class);

	@Autowired
	RecordService recordService;
	@Autowired
	UserService userService;
//	查询服务者(关联订单)收入以及提现记录
	@RequestMapping(value = "/record/getRecord", method = RequestMethod.POST)
	public @ResponseBody ApiResponse getRecord(@RequestParam String tokenId, @RequestBody String body) {
		JSONObject bodyObj = JSONObject.parseObject(body);
		User user = userService.getUserByToken(tokenId);
		if(user != null){
			List<UserRecord> record = recordService.getUserRecord(user.getId());
			return ApiResponse.successMessage("获取数据成功",record);
		}
		else {
			return ApiResponse.failMessage("用户验证失败");
		}
	}
}
