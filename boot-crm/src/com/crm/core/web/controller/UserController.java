package com.crm.core.web.controller;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crm.core.po.User;
import com.crm.core.service.UserService;

//用户控制类
@Controller
public class UserController {
	//依赖注入
	@Autowired
	private UserService userService;
	
	//用户登录
	@RequestMapping(value = "/login.action",method=RequestMethod.POST)
	public  String login(String usercode,String password,Model model ,HttpSession session) {
		
		//通过账号和密码查询用户
		User user=userService.findUser(usercode, password);
		if(user!=null) {
			//将用户对象添加到Session
			session.setAttribute("USER_SESSION", user);
			//跳转至主页
			return "redirect:customer/list.action";
		}
		model.addAttribute("msg", "账号或密码错误，请重新输入！");
		return "login";
	}
	
	@RequestMapping(value = "/toCustomer.action")
	public String toCustomer() {
		return "customer";
	}
	
	
	//退出登录
	
	@RequestMapping(value = "/logout.action")
	public String logout(HttpSession session) {
		//清楚Session
		session.invalidate();
		//重定向到登录页面的跳转方法
		return "redirect:login.action";
	}
	
	//向用户登录界面跳转
	@RequestMapping(value = "login.action")
	public String toLogin() {
	return "login";
	}
	
}
