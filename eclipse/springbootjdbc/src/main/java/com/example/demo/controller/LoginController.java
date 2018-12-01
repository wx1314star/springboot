package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 登录控制器
 * 
 * @author wx
 *
 *         Dec 1, 2018
 */
@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		// 这里写死掉了，没有去数据库查询，省时间
		if (null == userName || "".equals(userName) || !"wx".equals(userName)) {
			map.put("result", 0);
			return map;
		}
		if (null == passWord || "".equals(passWord) || !"123456".equals(passWord)) {
			map.put("result", 0);
			return map;
		}
		map.put("result", 1);
		return map;
	}
}
