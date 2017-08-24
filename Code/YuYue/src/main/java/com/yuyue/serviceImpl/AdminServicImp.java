package com.yuyue.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.yuyue.cache.redis.TokenManager;
import com.yuyue.mapper.AdminMapper;
import com.yuyue.model.Admin;
import com.yuyue.model.TokenModel;
import com.yuyue.service.AdminService;

@Transactional
@Service
public class AdminServicImp implements AdminService {
	final static Logger logger = LoggerFactory.getLogger(UserServiceImp.class);
	@Autowired
	AdminMapper adminMapper;
	@Autowired
	TokenManager tokenManager;

	@Override
	public Admin wxLogin(String unionId) {
		// TODO Auto-generated method stub
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
		Admin admin = adminMapper.selectByWxId(unionId);
		if (admin == null) {
			admin = new Admin();
			admin.setAdminWxid(unionId);
			int id = adminMapper.insert(admin);
			if (id > 0) {
				Admin newAdmin = adminMapper.selectByWxId(unionId);
				TokenModel model = tokenManager.createToken(newAdmin.getId());
				newAdmin.setAdminToken(model.getToken());
				adminMapper.updateByPrimaryKey(newAdmin);
				logger.info("user insert succcess:" + newAdmin);
				// data.put("nickname", nickname);
				// data.put("headimgurl", imageUrl);
				// data.put("token", model.getToken());
				result.put("code", "100");
				result.put("msg", data);
				return newAdmin;
			} else {
				logger.info("user insert fail:" + admin);
				result.put("code", "101");
				result.put("msg", "用户信息保存失败");
			}
		} else {
			TokenModel model = tokenManager.createToken(admin.getId());
			// data.put("nickname", nickname);
			// data.put("headimgurl", imageUrl);
			// data.put("token", model.getToken());
			logger.info("userInfo:" + admin);
			admin.setAdminToken(model.getToken());
			adminMapper.updateByPrimaryKey(admin);
			result.put("code", "100");
			result.put("data", data);
		}
		return admin;
	}
}
