package com.velocity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.velocity.exception.CustomerNotFoundException;
import com.velocity.model.Customer;
import com.velocity.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer getCustomer(int id) {
		Customer customer = customerRepository.findById(id);
		if (customer == null) {
			throw new CustomerNotFoundException("Customer ID is not found in the database");
		}

		return customer;
	}

	@Override
	public List<Customer> getPagination(int pageNo, int pageSize) {

		Pageable pageable = PageRequest.of(pageNo, pageSize);

		Page<Customer> pageResult = customerRepository.findAll(pageable);

		if (pageResult.hasContent()) {
			return pageResult.getContent();
		} else {
			return new ArrayList<Customer>();
		}
	}

	@Override
	public List<Customer> getCustomerByName(String name) {
		List<Customer> byName = customerRepository.findByName(name);
		return byName;
	}

	@Override
	public List<Customer> getByCity(String city) {
		List<Customer> customer = customerRepository.findByCity(city);
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers(Customer customer) {
		List<Customer> list = customerRepository.findAll();
		return list;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer update = customerRepository.save(customer);
		return update;
	}

	@Override
	public void deleteCustomer(Integer id) {
		customerRepository.deleteById(id);
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		Customer customer2 = customerRepository.save(customer);
		return customer2;
	}

}
