package com.demo.service;

import java.util.List;

import com.demo.model.Customer;

public interface CustomerService {
	
	// get operation based on id
	public Customer getCustomer(int id);
	
	//perform pagination to get record per page 
	public List<Customer> getPagination(int pageNo,int pageSize);
	
	//get operation based on city
	public List<Customer> getByCity(String city);
  
	// get operation based on name
	public List<Customer> getCustomerByName(String name);

	// save customer operation
	public Customer saveCustomer(Customer customer);

	// get all customers operation
	public List<Customer> getAllCustomers(Customer customer);

	// update customer operation
	public Customer updateCustomer(Customer customer);

	// delete customer operation
	public void deleteCustomer(Integer id);
	
	// save customer operation
	public Customer saveCustomerPolicyClaim(Customer customer);
	
}