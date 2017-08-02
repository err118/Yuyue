package com.yuyue.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.yuyue.mapper.UserMapper;
import com.yuyue.model.User;
import com.yuyue.service.UserService;
import com.yuyue.utils.Const;
import com.yuyue.utils.GenerateTokenUtil;
import com.yuyue.utils.HttpClientUtil;

@Service
public class UserServiceImp implements UserService {
	final static Logger logger = LoggerFactory.getLogger(UserServiceImp.class);
	@Autowired
	private UserMapper userMapper;

	@Override
	public User wxLogin(String wxCode) {
		// TODO Auto-generated method stub
		JSONObject data = new JSONObject();
		JSONObject result = new JSONObject();
		String resultStr = HttpClientUtil.dealGet("https://api.weixin.qq.com/sns/oauth2/access_token?appid="
				+ Const.WX_APPID + "&secret=" + Const.WX_SECRET + "&code=" + wxCode + "&grant_type=authorization_code");
		logger.info("wechat return:" + resultStr);
		JSONObject jsonObject = JSONObject.parseObject(resultStr);
		String accesstoken = jsonObject.getString("access_token");
		String openid = jsonObject.getString("openid");
		String unionId = jsonObject.getString("unionid");
		String info = HttpClientUtil
				.dealGet("https://api.weixin.qq.com/sns/userinfo?access_token=" + accesstoken + "&openid=" + openid);
		logger.info("wechat return:" + info);
		jsonObject = JSONObject.parseObject(info);
		String nickname = jsonObject.getString("nickname");
		String imageUrl = jsonObject.getString("headimgurl");
		String tokenId = GenerateTokenUtil.generateToken();
		User user = userMapper.selectByWxId(unionId);
		if(user == null){
			user = new User();
			user.setWxId(unionId);
			user.setToken(tokenId);
			int id = userMapper.insert(user);
			if (id > 0) {
				logger.info("user insert succcess:" + user);
				data.put("nickname", nickname);
				data.put("headimgurl", imageUrl);
				data.put("token", tokenId);
				result.put("code", "100");
				result.put("msg", data);
			} else {
				logger.info("user insert fail:" + user);
				result.put("code", "101");
				result.put("msg", "用户信息保存失败");
			}
		}
		else {
			data.put("nickname", nickname);
			data.put("headimgurl", imageUrl);
			data.put("token", tokenId);
			logger.info("userInfo:" + user);
			user.setToken(tokenId);
			userMapper.updateByPrimaryKey(user);
			result.put("code", "100");
			result.put("data", data);
		}
		return user;
	}

	@Override
	public int joinShop(String tokenId, int shopId) {
		// TODO Auto-generated method stub
		int status = userMapper.joinShop(tokenId, shopId);
		return status;
	}

}
