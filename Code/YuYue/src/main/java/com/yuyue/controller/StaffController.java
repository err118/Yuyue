package com.yuyue.controller;

import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yuyue.model.ApiResponse;
import com.yuyue.model.Staff;
import com.yuyue.service.StaffService;
import com.yuyue.service.UserService;

@Controller
public class StaffController {
	@Autowired
	StaffService staffService;
	final static Logger logger = LoggerFactory.getLogger(StaffController.class);

	// 获取管理员添加的员工
	@RequestMapping(value = "/shopStaff/getStaff", method = RequestMethod.POST)
	public @ResponseBody ApiResponse getStaff(@RequestParam String tokenId, @RequestBody String body) {
		JSONObject bodyObj = new JSONObject();
		long shopId = bodyObj.getIntValue("id");
		List<Staff> staff = staffService.getStaff(shopId);
		return ApiResponse.successMessage("获取成功", staff);
	}

	// 管理员添加员工
	@RequestMapping(value = "/shopStaff/addStaff", method = RequestMethod.POST)
	public @ResponseBody ApiResponse addStaff(@RequestParam String tokenId, @RequestBody String body) {
		JSONObject bodyObj = new JSONObject();
		String nickname = bodyObj.getString("nickname");
		String staffNo = bodyObj.getString("staffNo");
		int age = bodyObj.getIntValue("age");
		String sex = bodyObj.getString("sex");
		String coverOne = bodyObj.getString("coverOne");
		String coverTwo = bodyObj.getString("coverTwo");
		String coverThree = bodyObj.getString("coverThree");
		Staff staff = new Staff();
		staff.setNickname(nickname);
		staff.setStaffNo(staffNo);
		staff.setAge(age);
		staff.setSex(sex);
		staff.setCoverone(coverOne);
		staff.setCovertwo(coverTwo);
		staff.setCoverthree(coverThree);
		int status = staffService.addStaff(staff);
		if (status == 1) {
			return ApiResponse.successMessage("添加成功", "");
		}
		return ApiResponse.failMessage("添加失败");
	}

	// 删除管理员添加的员工
	@RequestMapping(value = "/shopStaff/deleteStaff", method = RequestMethod.POST)
	public @ResponseBody ApiResponse deleteStaff(@RequestParam String tokenId, @RequestBody String body) {
		JSONObject bodyObj = new JSONObject();
		long id = bodyObj.getIntValue("id");
		int status = staffService.deleteStaff(id);
		if (status == 1) {
			return ApiResponse.successMessage("删除成功", "");
		}
		return ApiResponse.failMessage("删除失败");
	}
}
