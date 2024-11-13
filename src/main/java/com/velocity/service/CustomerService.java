package com.velocity.service;

import java.util.List;

import com.velocity.model.Customer;

public interface CustomerService {

	// get operation based on id
	public Customer getCustomer(int id);

	
	//to get record per page 
	public List<Customer> getPagination(int pageNo,int pageSize);
	
	//get operation based on city
	public List<Customer> getByCity(String city);

	// to get record by name

	public List<Customer> getCustomerByName(String name);
}