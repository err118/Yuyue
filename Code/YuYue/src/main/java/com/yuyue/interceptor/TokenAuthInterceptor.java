package com.yuyue.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;
import com.yuyue.annotation.Authorization;
import com.yuyue.annotation.NoAuthorization;
import com.yuyue.cache.redis.TokenManager;
import com.yuyue.model.TokenModel;
import com.yuyue.utils.Const;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * 自定义拦截器，判断此次请求是否有权限
 * 
 * @see com.scienjus.authorization.annotation.Authorization
 * @author ScienJus
 * @date 2015/7/30.
 */
@Component
public class TokenAuthInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private TokenManager manager;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 如果不是映射到方法直接通过
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		if (method.getAnnotation(NoAuthorization.class) != null)
			return true;
		// 从header中得到token
		String authorization = request.getParameter(Const.AUTHORIZATION);
		// 验证token
		TokenModel model = manager.getToken(authorization);
		if (manager.checkToken(model)) {
			// //如果token验证成功，将token对应的用户id存在request中，便于之后注入
			// request.setAttribute(Const.CURRENT_USER_ID, model.getUserId());
			return true;
		}
		// //如果验证token失败，并且方法注明了Authorization，返回401错误
		// if (method.getAnnotation(Authorization.class) != null) {
		// response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		// return false;
		// }
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null ;
		JSONObject res = new JSONObject();
	    res.put("code","101");
	    res.put("msg","认证失败");
	    res.put("data", "");
	    out = response.getWriter();
	    out.append(res.toString());
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
	
}
