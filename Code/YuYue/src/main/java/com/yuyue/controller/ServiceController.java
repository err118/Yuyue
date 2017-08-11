package com.yuyue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuyue.model.ServiceWithUserInfo;
import com.yuyue.service.ServiceService;

@Controller
public class ServiceController {
	@Autowired
	ServiceService serviceService;

	@RequestMapping(value = "/service/getIndexUser", method = RequestMethod.GET)
	public @ResponseBody ServiceWithUserInfo getIndexUser() {
		return serviceService.getIndexUser();
	}
}
