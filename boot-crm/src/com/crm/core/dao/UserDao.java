package com.crm.core.dao;

import org.apache.ibatis.annotations.Param;

import com.crm.core.po.User;

public interface UserDao {
	
//	通过账号和密码查询用户
	public User findUser(@Param("usercode") String usercode,
							@Param("password") String password); 
}
