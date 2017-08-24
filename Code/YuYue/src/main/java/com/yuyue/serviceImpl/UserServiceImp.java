package com.yuyue.serviceImpl;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.yuyue.cache.redis.TokenManager;
import com.yuyue.mapper.UserMapper;
import com.yuyue.model.TokenModel;
import com.yuyue.model.User;
import com.yuyue.service.UserService;
import com.yuyue.utils.Const;
import com.yuyue.utils.GenerateTokenUtil;
import com.yuyue.utils.HttpClientUtil;

@Transactional
@Service
public class UserServiceImp implements UserService {
	final static Logger logger = LoggerFactory.getLogger(UserServiceImp.class);
	@Autowired
	private UserMapper userMapper;
	@Autowired
	TokenManager tokenManager;

	@Override
	public User wxLogin(String unionId) {
		// TODO Auto-generated method stub
		JSONObject data = new JSONObject();
		JSONObject result = new JSONObject();
		// String resultStr =
		// HttpClientUtil.dealGet("https://api.weixin.qq.com/sns/oauth2/access_token?appid="
		// + Const.WX_APPID + "&secret=" + Const.WX_SECRET + "&code=" + wxCode +
		// "&grant_type=authorization_code");
		// logger.info("wechat return:" + resultStr);
		// JSONObject jsonObject = JSONObject.parseObject(resultStr);
		// String accesstoken = jsonObject.getString("access_token");
		// String openid = jsonObject.getString("openid");
		// String unionId = jsonObject.getString("unionid");
		// String info = HttpClientUtil
		// .dealGet("https://api.weixin.qq.com/sns/userinfo?access_token=" +
		// accesstoken + "&openid=" + openid);
		// logger.info("wechat return:" + info);
		// jsonObject = JSONObject.parseObject(info);
		// String nickname = jsonObject.getString("nickname");
		// String imageUrl = jsonObject.getString("headimgurl");
		User user = userMapper.selectByWxId(unionId);
		if (user == null) {
			user = new User();
			user.setWxId(unionId);
			int id = userMapper.insert(user);
			if (id > 0) {
				User newUser = userMapper.selectByWxId(unionId);
				TokenModel model = tokenManager.createToken(newUser.getId());
				newUser.setToken(model.getToken());
				userMapper.updateByPrimaryKey(newUser);
				logger.info("user insert succcess:" + newUser);
				// data.put("nickname", nickname);
				// data.put("headimgurl", imageUrl);
				// data.put("token", model.getToken());
				result.put("code", "100");
				result.put("msg", data);
				return newUser;
			} else {
				logger.info("user insert fail:" + user);
				result.put("code", "101");
				result.put("msg", "用户信息保存失败");
			}
		} else {
			TokenModel model = tokenManager.createToken(user.getId());
			// data.put("nickname", nickname);
			// data.put("headimgurl", imageUrl);
			// data.put("token", model.getToken());
			logger.info("userInfo:" + user);
			user.setToken(model.getToken());
			userMapper.updateByPrimaryKey(user);
			result.put("code", "100");
			result.put("data", data);
		}
		return user;
	}

	@Override
	public int joinShop(long userId, long shopId) {
		// TODO Auto-generated method stub
		int status = userMapper.joinShop(userId, shopId);
		return status;
	}

	@Override
	public User getUserByToken(String tokenId) {
		// TODO Auto-generated method stub
		return userMapper.selectByToken(tokenId);
	}

	@Override
	public User selectUserByPrimaryKey(long id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateUserInfo(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKey(user);
	}
}
