package com.velocity.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.velocity.model.Customer;
import com.velocity.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	// save operation on customer
	@PostMapping("/customers")
	public Customer saveCustomer(@RequestBody Customer customer) {
		Customer customer2 = customerService.saveCustomer(customer);
		return customer2;

	}

	// get the list of customers
	@GetMapping("/customers/all")
	public List<Customer> getAllCustomer(Customer customer) {
		List<Customer> customer2 = customerService.getAllCustomer(customer);
		return customer2;
	}

	// get operation based on id
	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable int id) {
		Customer customer = customerService.getCustomer(id);
		return customer;

	}

	// update operation on customer
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		Customer customer2 = customerService.updateCustomer(customer);
		return customer2;
	}

	// delete operation on customer based on id
	@DeleteMapping("/customers/{id}")
	public void deleteCustomerById(@PathVariable int id) {
		customerService.deleteCustomerById(id);

	}

	// get operation based on city
	@GetMapping("/customers/getCity/{city}")
	public List<Customer> getByCity(@PathVariable("city") String city) {
		List<Customer> list = customerService.getByCity(city);
		return list;
	}

	@GetMapping("/customers/getName/{name}")
	public List<Customer> getCustomerByName(@PathVariable("name") String name) {
		List<Customer> customerByName = customerService.getCustomerByName(name);
		return customerByName;
	}

	@GetMapping("/customers")
	public List<Customer> getPagination(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize) {
		List<Customer> pagination = customerService.getPagination(pageNo, pageSize);
		return pagination;
	}

}
