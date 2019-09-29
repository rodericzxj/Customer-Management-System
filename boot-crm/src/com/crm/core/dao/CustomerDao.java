package com.crm.core.dao;

import java.util.List;


import com.crm.core.po.Customer;

public interface CustomerDao {
	//客户列表
	public List<Customer> selectCustomerList(Customer customer);
	
	//客户数
	public Integer selectCustomerListCount(Customer customer);

	public int createCustomer(Customer customer);

	public Customer getCustomerById(Integer id);

	public int updateCustomer(Customer customer);

	public int deleteCustomer(Integer id);
	
}
