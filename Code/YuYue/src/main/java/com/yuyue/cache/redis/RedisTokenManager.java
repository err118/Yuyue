package com.yuyue.cache.redis;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;

import com.yuyue.model.TokenModel;
import com.yuyue.utils.Const;
import com.yuyue.utils.GenerateTokenUtil;

/**
 * 通过Redis存储和验证token的实现类
 * 
 * @author ScienJus
 * @date 2015/7/31.
 */
@Component
public class RedisTokenManager implements TokenManager {

	private RedisTemplate redis;

	@Autowired
	public void setRedis(RedisTemplate redis) {
		this.redis = redis;
		// 泛型设置成Long后必须更改对应的序列化方案
		redis.setKeySerializer(new JdkSerializationRedisSerializer());
	}

	public TokenModel createToken(long userId) {
		// 使用uuid作为源token
		String token = GenerateTokenUtil.generateToken();
		TokenModel model = new TokenModel(userId, token);
		// 存储到redis并设置过期时间
		redis.boundValueOps(userId).set(token, Const.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
		return model;
	}

	public TokenModel getToken(String authentication) {
		if (authentication == null || authentication.length() == 0) {
			return null;
		}
		String[] param = authentication.split("_");
		if (param.length != 2) {
			return null;
		}
		// 使用userId和源token简单拼接成的token，可以增加加密措施
		long userId = Long.parseLong(param[0]);
		String token = param[1];
		return new TokenModel(userId, token);
	}

	public boolean checkToken(TokenModel model) {
		if (model == null) {
			return false;
		}
		String token = (String) redis.boundValueOps(model.getUserId()).get();
		if (token == null || !token.equals(model.getToken())) {
			return false;
		}
		// 如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
		redis.boundValueOps(model.getUserId()).expire(Const.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
		return true;
	}

	public void deleteToken(long userId) {
		redis.delete(userId);
	}

	public String getTokenFromRedis(long userId) {
		return (String)redis.boundValueOps(userId).get();
	}
}