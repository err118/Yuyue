package com.yuyue.controlleer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.alibaba.fastjson.JSONObject;
import com.yuyue.model.User;
import com.yuyue.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	final static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/user/wxLogin/{code}", method = RequestMethod.GET)
	public @ResponseBody User wxLogin(@PathVariable String code){
		JSONObject obj = new JSONObject();
		obj.put("code", code);
		User user = userService.wxLogin(code);
		return user;
	}
}
