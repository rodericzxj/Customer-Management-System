package com.crm.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.core.dao.UserDao;
import com.crm.core.po.User;
import com.crm.core.service.UserService;

//用户Service接口实现类

@Service ("userService")
@Transactional
public class UserServiceImpl implements UserService{
	//注入UserDao
	@Autowired
	private UserDao userDao;
	//通过账号和密码查询用户
	
	@Override
	public User findUser(String usercode,String password) {
		User user=this.userDao.findUser(usercode, password);
		return user;
	}
}
