package com.onestoit.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import com.google.gson.Gson;
import com.onestoit.controller.Code;
import com.onestoit.controller.Result;
import com.onestoit.model.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user = (User)request.getSession().getAttribute("userinfo");
		if (user == null) {  // 未ログイン
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			Result res = new Result(Code.ISNOT_LOGIN, null, "ログインしてください");
			response.getWriter().append(new Gson().toJson(res));
			return false;
		}
		return true;
	}
	
}
