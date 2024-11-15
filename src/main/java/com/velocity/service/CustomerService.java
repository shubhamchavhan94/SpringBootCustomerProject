package com.velocity.service;

import java.util.List;

import com.velocity.model.Customer;

public interface CustomerService {

	// save operation on customer
	public Customer saveCustomer(Customer customer);
	
	//update operation on customer
	public Customer updateCustomer(Customer customer);
	
	// get the List customer data
	public List<Customer> getAllCustomer(Customer customer);
	
	// get operation based on id
	public Customer getCustomer(int id);
	
	// delete operation on customer based on id
	public void deleteCustomerById(int id);

	
	//perform pagination to get record per page 
	public List<Customer> getPagination(int pageNo,int pageSize);
	
	//get operation based on city
	public List<Customer> getByCity(String city);

	// to get record by name
	public List<Customer> getCustomerByName(String name);
}