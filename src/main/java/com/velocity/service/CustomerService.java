package com.velocity.service;

import java.util.List;

import com.velocity.model.Customer;

public interface CustomerService {

	
	//get operation based on id
	public Customer getCustomer(int id);
	
	//to get record per page 
	public List<Customer> getPagination(int pageNo,int pageSize);
}